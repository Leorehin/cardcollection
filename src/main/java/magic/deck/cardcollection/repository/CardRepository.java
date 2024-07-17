package magic.deck.cardcollection.repository;

import magic.deck.cardcollection.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    @Query("SELECT c FROM tb_cards c WHERE c.name = :name")
    List<Card> findByName(String name);
}
