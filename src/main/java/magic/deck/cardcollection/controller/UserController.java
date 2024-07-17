package magic.deck.cardcollection.controller;


import magic.deck.cardcollection.model.User;
import magic.deck.cardcollection.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")


public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userToCreate){
        return ResponseEntity.ok(userServices.createUser(userToCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userServices.findById(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll(){
        return ResponseEntity.ok(userServices.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User userToUpdate,@PathVariable Long id){
        userServices.update(userToUpdate, id);
        return ResponseEntity.ok(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        userServices.delete(id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{userId}/{cardId}")
    public ResponseEntity<User> removeCardFromUser(@PathVariable Long userId,@PathVariable Long cardId){
        userServices.removeCardFromUser(userId,cardId);
        return ResponseEntity.ok().build();
    }
}
