package test.rest.controller;

import com.sun.jersey.api.view.Viewable;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Path( value = "/")
public class PersonApplicationTest {

    @GET
    @Path( value = "/" )
    @Produces( "text/html" )
    public Response showMainPage(  ) {

        Map< String, Object > model = new HashMap<>();
        model.put( "serverTime",  new Date() );

        return Response.ok( new Viewable( "/home", model ) ).build();
    }
}