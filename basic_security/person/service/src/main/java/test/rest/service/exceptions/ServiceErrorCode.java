package test.rest.service.exceptions;

public enum ServiceErrorCode {

    REST_SRVC_100( "Failed to get list of persons." ),
    REST_SRVC_101( "Failed to get person, id = %d." ),
    REST_SRVC_102( "Failed to add person, id = %d." ),
    REST_SRVC_103( "Failed to update person, id = %d." ),
    REST_SRVC_104( "Failed to delete person, id = %d." );

    private final String value;

    private ServiceErrorCode( String s ) {

        value = s;
    }

    public boolean equalsValue( String value2 ) {

        return ( value2 == null ) ? false : value.equals( value2 );
    }

    public String toString() {

        return value;
    }
}