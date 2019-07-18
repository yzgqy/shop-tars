package works.weave.socks.orders.orderserver.resources;

import org.hibernate.validator.constraints.URL;

import java.net.URI;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 21:42
 * @Description:
 */
public class NewOrderResource {
    @URL
    public URI customer;
    @URL
    public URI address;
    @URL
    public URI card;
    @URL
    public URI items;
}

