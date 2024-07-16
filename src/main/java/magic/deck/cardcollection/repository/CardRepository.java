package magic.deck.cardcollection.repository;

import magic.deck.cardcollection.model.Card;
import org.springframework.data.repository.CrudRepository;



public interface CardRepository extends CrudRepository<Card, Integer> {
}
