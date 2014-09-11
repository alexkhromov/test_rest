package test.rest.service;

import test.rest.pojo.Person;
import test.rest.service.exceptions.ServiceException;

import java.util.List;

public class PersonFacadeImpl implements PersonFacade {

    private PersonService personService;

    public void setPersonService( PersonService personService ) {

        this.personService = personService;
    }

    @Override
    public List findAll() throws ServiceException {

        return this.personService.findAll();
    }

    @Override
    public Person findById( Long id ) throws ServiceException {

        return this.personService.findById( id );
    }

    @Override
    public Person addPerson( Person person ) throws ServiceException {

        return this.personService.addPerson(person);
    }

    @Override
    public void updatePerson( Person person ) throws ServiceException {

        this.personService.updatePerson(person);
    }

    @Override
    public void deletePerson( Person person ) throws ServiceException {

        this.personService.deletePerson(person);
    }
}
