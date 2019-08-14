package by.danilov.musicInstrumentAssistant.web.exception;

import by.danilov.musicInstrumentAssistant.domain.entities.AbstractEntity;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String entityName, Long requestedId) {
        super(String.format("Entity of type '%s' with id='%d' not found", entityName, requestedId));
    }

    public EntityNotFoundException(String entityName){
        super(String.format("Entity of type '%s' not found", entityName));
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
