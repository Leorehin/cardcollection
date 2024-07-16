package magic.deck.cardcollection.Service;

import magic.deck.cardcollection.model.User;
import magic.deck.cardcollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServices {

    User create(User userToCreate);

    User findById(int id);

    List<User> findAll();

    User update(User userToUpdate);

    void delete(int id);

}
