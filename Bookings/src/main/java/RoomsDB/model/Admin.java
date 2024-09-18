package RoomsDB.model;

public class Admin {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;

    /* Constructors */
    public Admin() {

    }

    public Admin(int Id, String Firstname, String Lastname, String Username, String Password, String Email) {

        id = Id;
        firstname = Firstname;
        lastname = Lastname;
        username = Username;
        password = Password;
        email = Email;
    }

    /* Setters */
    public void setID(int Id) {
        id = Id;
    }

    public void setUsername(String Username) {
        username = Username;
    }

    public void setLastname(String Lastname) {
        lastname = Lastname;
    }

    public void setFirstname(String Firstname) {
        firstname = Firstname;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public void setPassword(String Password) {
        password = Password;
    }

    /* Getters */
    public int getID() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

}
