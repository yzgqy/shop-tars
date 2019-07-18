package works.weave.socks.cart.cartserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import works.weave.socks.cart.cartserver.entities.Cart;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/7/2 22:32
 * @Description:
 */
@RepositoryRestResource(exported = false)
public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findByCustomerId(@Param("custId") String id);
}

