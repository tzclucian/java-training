package org.tzc.geometry.exceptions;

public class GeometryException extends RuntimeException {
    public GeometryException() {
        super();
    }

    public GeometryException(String message) {
        super(message);
    }

    public GeometryException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeometryException(Throwable cause) {
        super(cause);
    }

    protected GeometryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
