package works.weave.socks.orders.orderserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import works.weave.socks.orders.orderserver.entities.CustomerOrder;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 21:42
 * @Description:
 */
@RepositoryRestResource(path = "orders", itemResourceRel = "order")
public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, String> {
    @RestResource(path = "customerId")
    List<CustomerOrder> findByCustomerId(@Param("custId") String id);
}
