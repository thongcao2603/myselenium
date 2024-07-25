package org.example.exceptions;

public class InvalidPathFileException extends FrameworkException{
    public InvalidPathFileException(String message) {
        super(message);
    }

    public InvalidPathFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
