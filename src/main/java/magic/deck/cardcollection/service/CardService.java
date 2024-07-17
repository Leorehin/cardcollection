package magic.deck.cardcollection.service;

import magic.deck.cardcollection.model.Card;

import java.util.List;

public interface CardService {

    Card createCard (Card cardToCreate);

    void removeCardById (Long id);

    Card updateCard (Card cardToUpdate, Long id);

    Card getCardById (Long cardId);

    List<Card> getCardByName (String cardName);

    Iterable<Card> getCards();
}
