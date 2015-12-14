package cn.ifengkou.athena.controller.exception;

/**
 * Created by Sloong on 2015/12/2.
 */
public class IllegalException extends Exception {
    public IllegalException() {
        super();
    }

    public IllegalException(String message) {
        super(message);
    }

    public IllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalException(Throwable cause) {
        super(cause);
    }
}
