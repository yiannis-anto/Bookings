/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomsDB.model;

public class Person {

    private String birthdate;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int telephone;
    private String username;

    private int id;

    /* constructors */
    public Person() {

    }

    public Person(int Id, String Birthdate, String Firstname, String Lastname, String Email,
            String Password, int Telephone, String Username) {

        id = Id;
        birthdate = Birthdate;
        firstname = Firstname;
        lastname = Lastname;
        email = Email;
        password = Password;
        telephone = Telephone;
        username = Username;

    }

    /* setters */
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
