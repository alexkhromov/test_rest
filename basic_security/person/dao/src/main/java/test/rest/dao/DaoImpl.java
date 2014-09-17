package test.rest.dao;

import org.hibernate.*;
import test.rest.dao.exceptions.DaoErrorCode;
import test.rest.dao.exceptions.DaoException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class DaoImpl< T, PK extends Serializable > implements Dao< T, PK > {

    private SessionFactory sessionFactory;
    private Class< T > type;
    private String typeName;

    public void setType( Class< T > type ) {

        this.type = type;
        typeName = type.getSimpleName();
    }

    public void setSessionFactory( SessionFactory sessionFactory ) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List< T > getAll() throws DaoException {

        try {
            List< T > list = getSession().createCriteria( type ).list();

            return list;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_001, typeName );
        }
    }

    @Override
    public T get( PK id ) throws DaoException {

        try {
            T object = ( T ) getSession().get( type, id );

            return object;
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_000, typeName, id );
        }
    }

    @Override
    public T add( T object ) throws DaoException {

        try {
            PK id = ( PK ) getSession().save( object );

            return get( id );
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_002, object );
        }
    }

    @Override
    public void update( T object ) throws DaoException {

        try {
            getSession().update( object );
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_003, object );
        }
    }

    @Override
    public void delete( T object ) throws DaoException {

        try {

            if ( object != null ) {

                getSession().delete( object );
            }
        } catch ( HibernateException e ) {
            throw new DaoException( e, DaoErrorCode.SCAND_DAO_004, object );
        }
    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();

        return session;
    }
}