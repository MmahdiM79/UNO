



/**
 * This class repersent a person.
 * it holds the name, and gender of the person
 * 
 * @author Mohammad Mahdi Malmasi
 * @version 0.1.0
 */
public class Person
{

            /* Feilds */
    
    // the first name of the person
    private String firstName;

    // the last name of the person
    private String lastName;

    // the age of the person
    private int age;

    // the gender of the person
    private String gender;
    





    
          /* Constructor */

    /**
     * Create a new Person with given details
     * 
     * @param firstName : the first name of person
     * @param lastName : the last name of person
     * @param age : the age of person
     * @param gender : the gender of person
     */
    public Person(String firstName, String lastName, int age, String gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }







            /* Methods */



    // * setter methods *

    /**
     * set the first name of the person
     * @param firstName : the first name of the person
     */
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }
    /**
     * set the last name of the person
     * @param lastName : the last name of the person
     */
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    /**
     * set the age of the person
     * @param age : the age of the person
     */
    public void setAge(int age) 
    {
        this.age = age;
    }
    /**
     * set the gender of the person
     * @param gender : the gender of the person to set
     */
    public void setGender(String gender) 
    {
        this.gender = gender;
    }
    

    // * getter methods *

    /**
     * @return the first name of the person
     */
    public String getFirstName() 
    {
        return firstName;
    }
    /**
     * @return the last name of the person
     */
    public String getLastName() 
    {
        return lastName;
    }
    /**
     * @return the age of the person
     */
    public int getAge() 
    {
        return age;
    }
    /**
     * @return the gender of the person
     */
    public String getGender() 
    {
        return gender;
    }
    



    /**
     * This method make a {@code String} of the person fields and their value
     * 
     * @return a string of the person details
     * 
     * @see an example of output:
     * @see .Person first name: Mohammad Mahdi,  Person last name:  Malmasi,  Person age: 19,  Person gender: male.
     */
    @Override
    public String toString()
    {
        return "Person first name: " + firstName + ",  "
                +
               "Person last name: " + lastName + ",  "
                +
               "Person age: " + age + ",  "
                +
               "Person gender: " + gender + ".\n";
    }


    /**
     * This method shows the person details in standarad output (terminal)
     * 
     * @see Person#toString()
     */
    public void print()
    {
        System.out.println(this.toString());
    }
}

