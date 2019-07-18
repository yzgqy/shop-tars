package works.weave.socks.cart.cartserver.cart;

import works.weave.socks.cart.cartserver.entities.Cart;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:26
 * @Description:
 */
public interface CartDAO {
    void delete(Cart cart);

    Cart save(Cart cart);

    List<Cart> findByCustomerId(String customerId);

    class Fake implements CartDAO {
        private Map<String, Cart> cartStore = new HashMap<>();

        @Override
        public void delete(Cart cart) {
            cartStore.remove(cart.customerId);
        }

        @Override
        public Cart save(Cart cart) {
            return cartStore.put(cart.customerId, cart);
        }

        @Override
        public List<Cart> findByCustomerId(String customerId) {
            Cart cart = cartStore.get(customerId);
            if (cart != null) {
                return Collections.singletonList(cart);
            } else {
                return Collections.emptyList();
            }
        }
    }
}

