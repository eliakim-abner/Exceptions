package br.com.eliakim.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final String mensage) {
        super(mensage);
    }
}
