package test.rest.service;

import test.rest.service.exceptions.ServiceException;
import test.rest.pojo.Person;

import java.util.List;

public interface PersonFacade {

    List findAll() throws ServiceException;

    Person findById( Long id ) throws ServiceException;

    Person addPerson( Person person ) throws ServiceException;

    void updatePerson( Person person ) throws ServiceException;

    void deletePerson( Person person ) throws ServiceException;
}
