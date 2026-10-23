package br.com.eliakim.exception;

public class EmptyStorageException extends RuntimeException{

    public EmptyStorageException(String message) {
        super(message);
    }
}
