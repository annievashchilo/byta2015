package exceptions;

/**
 * Created by Anny on 12.04.15.
 */
public class PlaneNotFoundException extends Exception {

    public PlaneNotFoundException() {
    }

    public PlaneNotFoundException(String message) {
        super(message);
    }

    public PlaneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaneNotFoundException(Throwable cause) {
        super(cause);
    }
}
