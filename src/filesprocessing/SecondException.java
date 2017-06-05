package filesprocessing;

/**
 * Second type of Exceptions, ERRORS.
 */
public class SecondException extends Exception {

    /**
     * Creates a SecondException object with a given message
     * @param message the content of the message
     */
    public SecondException(String message){
        super(message);
    }

    /**
     * prints the message in the wanted template
     * @return string with the message in the template
     */
    public String getMessage(){
        String messageFormat = "ERROR: " + super.getMessage() + "\n";
        return messageFormat;
    }
}
