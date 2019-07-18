package works.weave.socks.cart.cartserver.tars.cart.impl;

import com.qq.tars.spring.annotation.TarsServant;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import works.weave.socks.cart.cartserver.cart.CartDAO;
import works.weave.socks.cart.cartserver.cart.CartResource;
import works.weave.socks.cart.cartserver.entities.Cart;
import works.weave.socks.cart.cartserver.entities.Item;
import works.weave.socks.cart.cartserver.item.FoundItem;
import works.weave.socks.cart.cartserver.item.ItemDAO;
import works.weave.socks.cart.cartserver.item.ItemResource;
import works.weave.socks.cart.cartserver.tars.cart.ItemTars;
import works.weave.socks.cart.cartserver.tars.cart.ItemsControllerServant;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @Auther: yaya
 * @Date: 2019/7/3 17:27
 * @Description:
 */

@Component
@TarsServant("ItemsObj")
public class ItemsControllerServantImpl implements ItemsControllerServant {
    private final Logger LOG = getLogger(getClass());

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private CartsControllerServantImpl cartsControllerServantImpl;
    @Autowired
    private CartDAO cartDAO;

    @Override
    public ItemTars get(String customerId, String itemId) {
        return new FoundItem(() -> getItemsModel(customerId), () -> new Item(itemId)).get().toTars();
    }
    public Item getModel(@PathVariable String customerId, @PathVariable String itemId) {
        return new FoundItem(() -> getItemsModel(customerId), () -> new Item(itemId)).get();
    }

    @Override
    public List<ItemTars> getItems(String customerId) {
        List<Item> items =getItemsModel(customerId);
        List<ItemTars> itemTarsList = new ArrayList<>();
        for (Item item:items){
            itemTarsList.add(item.toTars());
        }
        return itemTarsList;
    }

    private List<Item> getItemsModel(String customerId){
        return getcart(customerId).contents();
    }

    private Cart getcart( String customerId){
        return new CartResource(cartDAO, customerId).value().get();
    }

    @Override
    public ItemTars addToCart(String customerId, ItemTars item) {
        Item itemModel = new Item();
        itemModel.setId(item.getId());
        itemModel.setItemId(item.getItemId());
        itemModel.setQuantity(item.getQuantity());
        itemModel.setUnitPrice(item.getUnitPrice());
        // If the item does not exist in the cart, create new one in the repository.
        FoundItem foundItem = new FoundItem(() -> getcart(customerId).contents(), () -> itemModel);
        if (!foundItem.hasItem()) {
            Supplier<Item> newItem = new ItemResource(itemDAO, () -> itemModel).create();
            LOG.debug("Did not find item. Creating item for user: " + customerId + ", " + newItem.get());
            new CartResource(cartDAO, customerId).contents().get().add(newItem).run();
            return itemModel.toTars();
        } else {
            Item newItem = new Item(foundItem.get(), foundItem.get().quantity() + 1);
            LOG.debug("Found item in cart. Incrementing for user: " + customerId + ", " + newItem);
            updateItem(customerId, newItem);
            return newItem.toTars();
        }
    }

    @Override
    public void removeItem(String customerId, String itemId) {
        FoundItem foundItem = new FoundItem(() -> getItemsModel(customerId), () -> new Item(itemId));
        Item item = foundItem.get();

        LOG.debug("Removing item from cart: " + item);
        new CartResource(cartDAO, customerId).contents().get().delete(() -> item).run();

        LOG.debug("Removing item from repository: " + item);
        new ItemResource(itemDAO, () -> item).destroy().run();
    }

    @Override
    public void updateItem(String customerId, ItemTars item) {
        Item itemModel = new Item(item);
        updateItem(customerId,itemModel);
    }

    private void updateItem(String customerId, Item item) {
        ItemResource itemResource = new ItemResource(itemDAO, () -> getModel(customerId, item.itemId()));
        LOG.debug("Merging item in cart for user: " + customerId + ", " + item);
        itemResource.merge(item).run();
    }

}

