package by.danilov.musicInstrumentAssistant.web.controller;

import by.danilov.musicInstrumentAssistant.domain.entities.User;
import by.danilov.musicInstrumentAssistant.repository.api.UserRepository;
import by.danilov.musicInstrumentAssistant.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/load/{login}")
    public ResponseEntity<User> loadUserByLogin(@PathVariable String login){
        if (login != null) {
            User user = repository.findUserByLogin(login).orElseThrow(() ->
                    new UserNotFoundException(login));
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
