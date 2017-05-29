package filesprocessing;

/**
 * Created by Yanir on 29/05/2017.
 */
public class SecondException extends Exception {

    public SecondException(String message){
        super(message);
    }

    public String getMessage(){
        String messageFormat = "ERROR: " + super.getMessage() + "\n";
        return messageFormat;
    }
}
