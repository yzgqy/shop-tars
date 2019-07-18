package works.weave.socks.cart.cartserver.cart;

import java.util.function.Supplier;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:27
 * @Description:
 */
public interface HasContents<T extends Contents> {
    Supplier<T> contents();
}

