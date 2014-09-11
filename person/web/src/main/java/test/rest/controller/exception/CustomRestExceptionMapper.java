package test.rest.controller.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomRestExceptionMapper implements ExceptionMapper< CustomRestException > {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse( CustomRestException e ) {

        return Response.status( e.getStatus() )
                       .entity( e.getReason() )
                       .type( MediaType.TEXT_PLAIN ).build();
    }
}
