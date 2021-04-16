package Exceptions;

public class MaximumAttemptsException extends RuntimeException{
    public MaximumAttemptsException(String errorMessage ){
        super( errorMessage );
    }
}
