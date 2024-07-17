package magic.deck.cardcollection.service.implementations;

import magic.deck.cardcollection.service.CardService;
import magic.deck.cardcollection.model.Card;
import magic.deck.cardcollection.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CardServImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public Card createCard(Card cardToCreate) {
        cardToCreate.setName(cardNameDefaultFormat(cardToCreate.getName()));
        return cardRepository.save(cardToCreate);
    }

    @Override
    public void removeCardById(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public Card updateCard(Card cardToUpdate, Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        cardToUpdate.setName(cardNameDefaultFormat(cardToUpdate.getName()));
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();

            card.setName(cardToUpdate.getName());
            card.setDescription(cardToUpdate.getDescription());
            card.setColor(cardToUpdate.getColor());
            card.setType(cardToUpdate.getType());

            return cardRepository.save(card);
        }else {
            throw new NoSuchElementException("Usuario nao existe");
        }
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Card> getCardByName(String cardName) {
        return cardRepository.findByName(cardNameDefaultFormat(cardName));
    }

    @Override
    public Iterable<Card> getCards() {
        return cardRepository.findAll();
    }

    private String cardNameDefaultFormat(String cardName) {
        return cardName.toLowerCase()
                .trim()
                .replaceAll("\\s+", "");
    }
}
