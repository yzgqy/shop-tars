package works.weave.socks.cart.cartserver.cart;

import works.weave.socks.cart.cartserver.entities.Cart;

import java.util.function.Supplier;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:28
 * @Description:
 */
public interface Resource<T> {
    Runnable destroy();

    Supplier<T> create();

    Supplier<T> value();

    Runnable merge(T toMerge);

    class CartFake implements Resource<Cart> {
        private final String customerId;
        private Cart cart = null;

        public CartFake(String customerId) {
            this.customerId = customerId;
        }

        @Override
        public Runnable destroy() {
            return () -> cart = null;
        }

        @Override
        public Supplier<Cart> create() {
            return () -> cart = new Cart(customerId);
        }

        @Override
        public Supplier<Cart> value() {
            if (cart == null) {
                create().get();
            }
            return () -> cart;
        }

        @Override
        public Runnable merge(Cart toMerge) {
            return null;
        }
    }
}

