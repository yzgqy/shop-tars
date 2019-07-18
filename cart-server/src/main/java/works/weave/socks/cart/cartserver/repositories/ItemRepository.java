package works.weave.socks.cart.cartserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import works.weave.socks.cart.cartserver.entities.Item;

@RepositoryRestResource
public interface ItemRepository extends MongoRepository<Item, String> {
}
