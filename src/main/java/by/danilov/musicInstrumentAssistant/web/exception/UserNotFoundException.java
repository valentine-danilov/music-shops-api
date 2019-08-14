package by.danilov.musicInstrumentAssistant.web.exception;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String login){
        super(String.format("User with login %s does not exist", login));
    }
}
