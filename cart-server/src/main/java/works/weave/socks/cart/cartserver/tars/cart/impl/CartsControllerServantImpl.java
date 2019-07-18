package works.weave.socks.cart.cartserver.tars.cart.impl;

import com.qq.tars.spring.annotation.TarsServant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import works.weave.socks.cart.cartserver.cart.CartDAO;
import works.weave.socks.cart.cartserver.cart.CartResource;
import works.weave.socks.cart.cartserver.entities.Cart;
import works.weave.socks.cart.cartserver.tars.cart.CartTars;
import works.weave.socks.cart.cartserver.tars.cart.CartsControllerServant;

/**
 * @Auther: yaya
 * @Date: 2019/7/3 17:27
 * @Description:
 */

@Component
@TarsServant("CartsObj")
public class CartsControllerServantImpl implements CartsControllerServant {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CartDAO cartDAO;

    @Override
    public CartTars get(String customerId) {
        Cart cart = new CartResource(cartDAO, customerId).value().get();
        return cart.toTars();
    }

    @Override
    public void delete(String customerId) {
        new CartResource(cartDAO, customerId).destroy().run();
    }

    @Override
    public void mergeCarts(String customerId, String sessionId) {
        logger.debug("Merge carts request received for ids: " + customerId + " and " + sessionId);
        CartResource sessionCart = new CartResource(cartDAO, sessionId);
        CartResource customerCart = new CartResource(cartDAO, customerId);
        customerCart.merge(sessionCart.value().get()).run();
        delete(sessionId);
    }
}
