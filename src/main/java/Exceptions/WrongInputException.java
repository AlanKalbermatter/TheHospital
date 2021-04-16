package Exceptions;

import org.apache.log4j.Logger;

public class WrongInputException extends RuntimeException{
    private static final Logger logger = Logger.getLogger(WrongInputException.class);

    public WrongInputException( String errorMessage ){
        logger.error(errorMessage);
    }
}
