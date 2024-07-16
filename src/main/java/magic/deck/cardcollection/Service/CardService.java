package magic.deck.cardcollection.Service;

import magic.deck.cardcollection.model.Card;

import java.util.List;

public interface CardService {

    Card createCard (Card cardToCreate);

    Card removeCard (Card cardToRemove);

    Card updateCard (Card cardToUpdate);

    Card getCard (int cardId);

    Card getCard (String cardName);

    List<Card> getCards();
}
