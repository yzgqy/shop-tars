// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package works.weave.socks.shipping.shippingserver.tars.shipping;

import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.annotation.*;
import com.qq.tars.common.support.Holder;

@Servant
public interface ShippingControllerServant {

	public String getShipping();

	public String getShippingById(String id);

	public ShipmentTars postShipping(ShipmentTars shipment);
}
