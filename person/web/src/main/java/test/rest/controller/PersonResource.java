package test.rest.controller;

import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import test.rest.controller.exception.CustomRestException;
import test.rest.pojo.Person;
import test.rest.service.PersonFacade;
import test.rest.service.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

@Component
@Path( value = "/data")
public class PersonResource {

    @Autowired
    PersonFacade personFacade;

    @Context
    SecurityContext sc;

    @Context
    HttpHeaders headers;

    @GET
    @Path( value = "/get/{id}" )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public Response findPersonById( @PathParam( "id" ) Long id, @Context HttpHeaders headers ) {

        if ( ( headers.getAcceptableMediaTypes().contains( MediaType.valueOf( MediaType.APPLICATION_XHTML_XML ) ) ||
                headers.getAcceptableMediaTypes().contains( MediaType.valueOf( MediaType.APPLICATION_JSON ) ) ) == false )
            throw new CustomRestException( "Unsupported media type!",
                "Unsupported media type!", Response.Status.UNSUPPORTED_MEDIA_TYPE, 415 );

        Person person = null;

        try {
            person = personFacade.findById( id );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        if ( person == null ) {
            throw new CustomRestException( "Can't find person with id = " + id,
                    "Person with id = " + id + " doesn't exist!", Response.Status.NOT_FOUND, 404 );
        }

        return Response.status( 200 ).entity( person ).build();
    }

    @GET
    @Path( value = "/get" )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public Response findAll() {

        List persons = null;
        GenericEntity< List< Person > > entity = null;

        try {
            persons = personFacade.findAll();
            entity = new GenericEntity< List< Person > >( persons ) { };
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        if ( persons == null || entity == null ) {
            throw new CustomRestException( "Can't find persons!",
                    "Can't find persons!", Response.Status.NOT_FOUND, 404 );
        }

        return Response.status( 200 ).entity( entity ).build();
    }

    @POST
    @Path( value = "/add" )
    @Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public Response addPerson() {

        Person person = new Person();
        person.setName( "Test" );
        person.setAge( 23 );
        person.setHireDate( new Date() );
        person.setPosition( "Test" );
        person.setExperience( 5 );
        person.setSalary( 1000 );

        try {
            person = personFacade.addPerson( person );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        if ( person.getId() == null ) {
            throw new CustomRestException( "Can't add person " + person,
                    "Can't add person " + person, Response.Status.BAD_REQUEST, 400 );
        }

        return Response.status( 200 ).entity( person ).build();
    }

    @PUT
    @Path( value = "/update/{id}" )
    @Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    /*@RolesAllowed( "restful" )*/
    public Response updatePerson( @PathParam( "id" ) Long id ) {

        Person person = null;

        try {
            person = personFacade.findById( id );
            person.setPosition( "updated" );
            person.setName( "updated" );
            personFacade.updatePerson( person );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        if ( person == null ) {
            throw new CustomRestException( "Can't update person with id = " + id + " It doesn't exist!",
                    "Person with id = " + id + " doesn't exist!", Response.Status.NOT_FOUND, 404 );
        }

        return Response.status( 200 ).entity( person ).build();
    }

    @DELETE
    @Path( value = "/delete/{id}" )
    @Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    /*@RolesAllowed( "restful" )*/
    public Response deletePerson( @PathParam( "id" ) Long id ) {

       /* if ( !sc.isUserInRole( "admin" ) )
            throw new CustomRestException( "Access denied!",
                    "Access denied!", Response.Status.FORBIDDEN, 403 );*/

        Person person = null;

        try {
            person = personFacade.findById( id );
            personFacade.deletePerson( person );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        if ( person == null ) {
            throw new CustomRestException( "Can't delete person with id = " + id + " It doesn't exist!",
                    "Person with id = " + id + " doesn't exist!", Response.Status.NOT_FOUND, 404 );
        }

        return Response.status( 200 ).entity( person ).build();
    }
}