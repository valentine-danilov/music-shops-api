package by.danilov.musicInstrumentAssistant.web.controller.advice;

import by.danilov.musicInstrumentAssistant.web.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DefaultExceptionError {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> entityNotFoundHandler(HttpServletRequest req, Exception e) {
        String errorUrl = req.getRequestURL().toString();

        ErrorInfo errorInfo = ErrorInfo.builder()
                .message(e.getMessage() != null
                        ? e.getMessage()
                        : "Something went wrong")
                .url(errorUrl)
                .build();

        if (e instanceof NoHandlerFoundException) {
            errorInfo.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
        } else {
            errorInfo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
