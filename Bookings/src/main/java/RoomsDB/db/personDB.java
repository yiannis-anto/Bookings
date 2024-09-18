package RoomsDB.db;

import RoomsDB.model.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class personDB {

    public static void addPerson(Person person) {

        Statement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO PERSON")
                    .append("(birthdate, firstname, lastname, email, password, telephone, username) ")
                    .append("VALUES (")
                    .append("'").append(person.getBirthdate()).append("',")
                    .append("'").append(person.getFirstname()).append("',")
                    .append("'").append(person.getLastname()).append("',")
                    .append("'").append(person.getEmail()).append("',")
                    .append("'").append(person.getPassword()).append("',")
                    .append("'").append(person.getTelephone()).append("',")
                    .append("'").append(person.getUsername()).append("');");

            stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                person.setId(rs.getInt(1));

            }

            System.out.println("#DB: The person was successfully added in the database.");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static Person getPerson(String Username) {

        Person person = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM PERSON ")
                    .append("WHERE username = ").append("'").append(Username).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                person = new Person();

                person.setBirthdate(res.getString("birthdate"));
                person.setFirstname(res.getString("firstname"));
                person.setLastname(res.getString("lastname"));
                person.setEmail(res.getString("email"));
                person.setPassword(res.getString("password"));
                person.setTelephone(res.getInt("telephone"));
                person.setId(res.getInt("id"));
                person.setUsername(res.getString("username"));

            } else {
                System.out.println("#DB: Person with username " + Username + " was not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return person;

    }

    public static boolean checkValidUsernamePerson(String username) throws ClassNotFoundException, SQLException {

        boolean valid = true;

        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM PERSON ")
                    .append(" WHERE ")
                    .append(" username = ").append("'").append(username).append("';");

            stmt.execute(insQuery.toString());

            if (stmt.getResultSet().next() == true) {
                System.out.println("#DB: This username already exists");
                valid = false;
            }

        } catch (SQLException ex) {

            System.out.println("#Check username person Error in SQL exception..." + ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return valid;
    }

}
