package test.rest.controller.exception;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomRestException extends RuntimeException {

    private String message;
    private String reason;
    private Response.Status status;
    private int errorCode;

    public CustomRestException( String message, String reason, Response.Status status, int errorCode ) {

        super( message );

        this.message = message;
        this.reason = reason;
        this.status = status;
        this.errorCode = errorCode;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage( String message ) {

        this.message = message;
    }

    public int getErrorCode() {

        return errorCode;
    }

    public void setErrorCode( int errorCode ) {

        this.errorCode = errorCode;
    }

    public String getReason() {

        return reason;
    }

    public void setReason( String reason ) {

        this.reason = reason;
    }

    public Response.Status getStatus() {

        return status;
    }

    public void setStatus( Response.Status status ) {

        this.status = status;
    }
}
