package works.weave.socks.shipping.shippingserver.tars.shipping.impl;

import com.qq.tars.spring.annotation.TarsServant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import works.weave.socks.shipping.shippingserver.tars.shipping.ShipmentTars;
import works.weave.socks.shipping.shippingserver.tars.shipping.ShippingControllerServant;

/**
 * @Auther: yaya
 * @Date: 2019/7/10 16:23
 * @Description:
 */
@TarsServant("ShippingObj")
public class ShippingControllerServantImpl implements ShippingControllerServant {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public String getShipping() {
        return "GET ALL Shipping Resource.";
    }

    @Override
    public String getShippingById(String id) {
        return "GET Shipping Resource with id: " + id;
    }

    @Override
    public ShipmentTars postShipping(ShipmentTars shipment) {
        System.out.println("Adding shipment to queue...");
        try {
            rabbitTemplate.convertAndSend("shipping-task", shipment);
        } catch (Exception e) {
            System.out.println("Unable to add to queue (the queue is probably down). Accepting anyway. Don't do this " +
                    "for real!");
        }
        return shipment;
    }
}
