package works.weave.socks.cart.cartserver.cart;

import works.weave.socks.cart.cartserver.action.FirstResultOrDefault;
import works.weave.socks.cart.cartserver.entities.Cart;

import java.util.function.Supplier;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:29
 * @Description:
 */
public class CartResource implements Resource<Cart>, HasContents<CartContentsResource> {
    private final CartDAO cartRepository;
    private final String customerId;

    public CartResource(CartDAO cartRepository, String customerId) {
        this.cartRepository = cartRepository;
        this.customerId = customerId;
    }

    @Override
    public Runnable destroy() {
        return () -> cartRepository.delete(value().get());
    }

    @Override
    public Supplier<Cart> create() {
        return () -> cartRepository.save(new Cart(customerId));
    }

    @Override
    public Supplier<Cart> value() {
        return new FirstResultOrDefault<>(
                cartRepository.findByCustomerId(customerId),
                () -> {
                    create().get();
                    return value().get();
                });
    }

    @Override
    public Runnable merge(Cart toMerge) {
        return () -> toMerge.contents().forEach(item -> contents().get().add(() -> item).run());
    }

    @Override
    public Supplier<CartContentsResource> contents() {
        return () -> new CartContentsResource(cartRepository, () -> this);
    }
}

