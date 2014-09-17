package test.rest.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Person {

    private Long id;
    private Integer age;
    private String name;
    private Date hireDate;
    private String position;
    private Integer experience;
    private Integer salary;

    public Person() {
    }

    public Integer getAge() {

        return age;
    }

    public void setAge( Integer age ) {

        this.age = age;
    }

    public Integer getExperience() {

        return experience;
    }

    public void setExperience( Integer experience ) {

        this.experience = experience;
    }

    public Date getHireDate() {

        return hireDate;
    }

    public void setHireDate( Date hireDate ) {

        this.hireDate = hireDate;
    }

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition( String position ) {

        this.position = position;
    }

    public Integer getSalary() {

        return salary;
    }

    public void setSalary( Integer salary ) {

        this.salary = salary;
    }

    @Override
    public boolean equals( Object o ) {

        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Person person = (Person) o;

        if ( !age.equals( person.age ) ) return false;
        if ( !experience.equals( person.experience ) ) return false;
        if ( !hireDate.equals( person.hireDate ) ) return false;
        if ( !id.equals( person.id ) ) return false;
        if ( !name.equals( person.name ) ) return false;
        if ( !position.equals( person.position ) ) return false;
        if ( !salary.equals( person.salary ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + experience.hashCode();
        result = 31 * result + salary.hashCode();

        return result;
    }

    @Override
    public String toString() {

        return "Person{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }
}
