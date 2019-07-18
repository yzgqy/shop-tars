package works.weave.socks.orders.orderserver.tars.order.impl;

import com.qq.tars.spring.annotation.TarsServant;
import works.weave.socks.orders.orderserver.tars.order.CustomerOrderTars;
import works.weave.socks.orders.orderserver.tars.order.NewOrderResourceTars;
import works.weave.socks.orders.orderserver.tars.order.OrdersControllerServant;

/**
 * @Auther: yaya
 * @Date: 2019/7/15 18:41
 * @Description:
 */
@TarsServant("OrderObj")
public class OrdersControllerServantImpl implements OrdersControllerServant {
    @Override
    public CustomerOrderTars newOrder(NewOrderResourceTars item) {
        return null;
    }
}
