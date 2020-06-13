package unicesumar.segundoBimestre.forum.exception;

public class LivroIdsDiferentException extends RuntimeException{
    public LivroIdsDiferentException() {
        super("Os ids dos livros são diferentes");
    }
}
