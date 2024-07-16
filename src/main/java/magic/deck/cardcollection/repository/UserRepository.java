package magic.deck.cardcollection.repository;

import magic.deck.cardcollection.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
