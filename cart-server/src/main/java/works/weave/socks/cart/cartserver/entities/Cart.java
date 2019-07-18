package works.weave.socks.cart.cartserver.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import works.weave.socks.cart.cartserver.tars.cart.CartTars;
import works.weave.socks.cart.cartserver.tars.cart.ItemTars;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:21
 * @Description:
 */
@Document
public class Cart {
    @NotNull
    public String customerId; // Public instead of getters/setters.
    @Id
    private String id;
    @DBRef
    private List<Item> items = new ArrayList<>();

    public Cart(String customerId) {
        this.customerId = customerId;
    }

    public Cart() {
        this(null);
    }

    public List<Item> contents() {
        return items;
    }

    public Cart add(Item item) {
        items.add(item);
        return this;
    }

    public Cart remove(Item item) {
        items.remove(item);
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (customerId != null ? !customerId.equals(cart.customerId) : cart.customerId != null) return false;
        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public CartTars toTars(){
        CartTars cartTars = new CartTars();
        cartTars.setId(this.id);
        cartTars.setCustomerId(this.customerId);
        List<Item> items = this.items;
        List<ItemTars> itemTarsList = new ArrayList<>();
        for(Item item :items){
            itemTarsList.add(item.toTars());
        }
        cartTars.setItems(itemTarsList);
        return cartTars;
    }
}
