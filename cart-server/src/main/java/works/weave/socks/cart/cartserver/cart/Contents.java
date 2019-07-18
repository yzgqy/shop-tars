package works.weave.socks.cart.cartserver.cart;

import works.weave.socks.cart.cartserver.entities.Item;

import java.util.List;
import java.util.function.Supplier;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:26
 * @Description:
 */
public interface Contents<T> {
    Supplier<List<T>> contents();

    Runnable add(Supplier<Item> item);

    Runnable delete(Supplier<Item> item);
}
