package test.rest.service;

import test.rest.dao.Dao;
import test.rest.dao.exceptions.DaoException;
import test.rest.pojo.Person;
import test.rest.service.exceptions.ServiceErrorCode;
import test.rest.service.exceptions.ServiceException;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private Dao< Person, Long > personDao;

    public void setPersonDao( Dao< Person, Long > personDao ) {

        this.personDao = personDao;
    }

    @Override
    public List< Person > findAll() throws ServiceException {

        List< Person > persons;

        try {
            persons = personDao.getAll();

            return persons;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.REST_SRVC_100 );
        }
    }

    @Override
    public Person findById( Long id ) throws ServiceException {

        Person person;

        try {
            person = personDao.get( id );

            return person;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.REST_SRVC_101, id );
        }
    }

    @Override
    public Person addPerson( Person person ) throws ServiceException {

        try {
            person = personDao.add( person );

            return person;
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.REST_SRVC_102, person.getId() );
        }
    }

    @Override
    public void updatePerson( Person person ) throws ServiceException {

        try {
            personDao.update( person );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.REST_SRVC_103, person.getId() );
        }
    }

    @Override
    public void deletePerson( Person person ) throws ServiceException {

        try {
            personDao.delete( person );
        } catch ( DaoException e) {
            throw new ServiceException( e, ServiceErrorCode.REST_SRVC_104, person.getId() );
        }
    }
}