package unicesumar.segundoBimestre.forum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import unicesumar.segundoBimestre.forum.exception.LivroIdsDiferentException;
import unicesumar.segundoBimestre.forum.exception.LivroInvalidException;
import unicesumar.segundoBimestre.forum.exception.LivroNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(LivroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  void handle(LivroNotFoundException e){
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LivroIdsDiferentException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public  void handle(LivroIdsDiferentException e){
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LivroInvalidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handle(LivroInvalidException e){
        return e.getMessage();
    }

}
