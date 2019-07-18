package works.weave.socks.cart.cartserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import works.weave.socks.cart.cartserver.cart.CartDAO;
import works.weave.socks.cart.cartserver.entities.Cart;
import works.weave.socks.cart.cartserver.entities.Item;
import works.weave.socks.cart.cartserver.item.ItemDAO;
import works.weave.socks.cart.cartserver.repositories.CartRepository;
import works.weave.socks.cart.cartserver.repositories.ItemRepository;

import java.util.List;

@Configuration
public class BeanConfiguration {
    @Bean
    @Autowired
    public CartDAO getCartDao(CartRepository cartRepository) {
        return new CartDAO() {
            @Override
            public void delete(Cart cart) {
                cartRepository.delete(cart);
            }

            @Override
            public Cart save(Cart cart) {
                return cartRepository.save(cart);
            }

            @Override
            public List<Cart> findByCustomerId(String customerId) {
                return cartRepository.findByCustomerId(customerId);
            }
        };
    }

    @Bean
    @Autowired
    public ItemDAO getItemDao(ItemRepository itemRepository) {
        return new ItemDAO() {
            @Override
            public Item save(Item item) {
                return itemRepository.save(item);
            }

            @Override
            public void destroy(Item item) {
                itemRepository.delete(item);
            }

            @Override
            public Item findOne(String id) {
                return itemRepository.findById(id).orElse(null) ;
            }
        };
    }
}



