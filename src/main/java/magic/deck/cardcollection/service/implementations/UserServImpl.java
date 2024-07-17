package magic.deck.cardcollection.service.implementations;

import magic.deck.cardcollection.service.UserServices;
import magic.deck.cardcollection.model.Card;
import magic.deck.cardcollection.model.User;
import magic.deck.cardcollection.repository.CardRepository;
import magic.deck.cardcollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServImpl implements UserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CardRepository cardRepository;

    //O usuario so pode ser criado com uma carta.
    @Override
    public User createUser(User userToCreate) {
        if(userToCreate != null) {
            return userRepository.save(userToCreate);
        }else{
            throw new IllegalArgumentException("usuario nao pode ser nulo");
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User userToUpdate, Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.setName(userToUpdate.getName());
            user.setLogin(userToUpdate.getLogin());
            user.setPassword(userToUpdate.getPassword());

            return userRepository.save(user);
        }else {
            throw new NoSuchElementException("Usuario nao existe");
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /*@Override
    public Card addNewCardToUser(Long userId, Card cardToAdd) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            userRepository.save(user);
        }else{
            throw new NoSuchElementException("Usuario nao existe");
        }

    }

    @Override
    public Card addCardExistentToUser(Long userId, Long cardId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);
        if (userOptional.isPresent() && cardOptional.isPresent()) {
            Card card = cardOptional.get();
            User user = userOptional.get();
            user.getCardsList().add(card);
            userRepository.save(user);
        }
        else {
            throw new NoSuchElementException("Usuario nao existe");
        }
    }*/
/*
    @Override
    public void removeCardFromUser(Long userId, Long cardId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);
        if (userOptional.isPresent() && cardOptional.isPresent()) {
            User user = userOptional.get();
            Card card = cardOptional.get();
            user.getCardsList().remove(card);
            userRepository.save(user);
        }
        else {
            throw new NoSuchElementException("Usuario ou carta nao existem");
        }
    }*/
}
