package exceptions;

/**
 * Created by Hanna_Vashchilo on 4/14/2015.
 */
public class DBNotFoundException extends Exception {

    public DBNotFoundException() {
    }

    public DBNotFoundException(String message) {
        super(message);
    }

    public DBNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBNotFoundException(Throwable cause) {
        super(cause);
    }
}
