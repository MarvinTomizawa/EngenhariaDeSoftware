package unicesumar.segundoBimestre.forum.exception;

public class LivroInvalidException extends RuntimeException{
    public LivroInvalidException(String invalidField) {
        super("Campo inválido:" + invalidField);
    }
}
