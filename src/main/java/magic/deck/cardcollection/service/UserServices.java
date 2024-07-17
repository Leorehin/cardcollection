package magic.deck.cardcollection.service;

import magic.deck.cardcollection.model.Card;
import magic.deck.cardcollection.model.User;


public interface UserServices {

    User createUser(User userToCreate);

    User findById(Long id);

    Iterable<User> findAll();

    User update(User userToUpdate, Long id);

    void delete(Long id);

    //Card addNewCardToUser(Long userId, Card cardToAdd);

    //Card addCardExistentToUser(Long userId, Long cardId);

    //void removeCardFromUser(Long userId, Long cardId);

}
