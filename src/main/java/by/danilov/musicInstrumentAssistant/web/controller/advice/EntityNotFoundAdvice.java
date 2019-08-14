package by.danilov.musicInstrumentAssistant.web.controller.advice;

import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import by.danilov.musicInstrumentAssistant.web.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class EntityNotFoundAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorInfo> entityNotFoundHandler(HttpServletRequest req, EntityNotFoundException e){
        String errorUrl = req.getRequestURL().toString();

        ErrorInfo errorInfo = ErrorInfo.builder()
                .message(e.getMessage())
                .url(errorUrl)
                .build();
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorInfo> userNotFoundHandler(HttpServletRequest req, UserNotFoundException e){
        String errorUrl = req.getRequestURL().toString();

        ErrorInfo errorInfo = ErrorInfo.builder()
                .message(e.getMessage())
                .url(errorUrl)
                .code(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

}
