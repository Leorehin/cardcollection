package magic.deck.cardcollection.controller;

import magic.deck.cardcollection.model.Card;
import magic.deck.cardcollection.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard (@RequestBody Card cardToCreate){
        return ResponseEntity.ok(cardService.createCard(cardToCreate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> removeCardById (@PathVariable Long id){
        cardService.removeCardById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard (@RequestBody Card cardToUpdate,@PathVariable Long id){
        return ResponseEntity.ok(cardService.updateCard(cardToUpdate, id));
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCardById (Long cardId){
        return ResponseEntity.ok(cardService.getCardById(cardId));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<Card>> getCardByName (@RequestParam String cardName){
        return ResponseEntity.ok(cardService.getCardByName(cardName));
    }

    @GetMapping
    public ResponseEntity<Iterable<Card>> getCards(){
        return ResponseEntity.ok(cardService.getCards());
    }
}
