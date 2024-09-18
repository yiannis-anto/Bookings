package RoomsDB.db;

import RoomsDB.model.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class employeeDB {

    public static void addEmployee(Employee employee) {

        Statement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO EMPLOYEE")
                    .append("(firstname, lastname, username, password, email) ")
                    .append("VALUES (")
                    .append("'").append(employee.getFirstname()).append("',")
                    .append("'").append(employee.getLastname()).append("',")
                    .append("'").append(employee.getUsername()).append("',")
                    .append("'").append(employee.getPassword()).append("',")
                    .append("'").append(employee.getEmail()).append("');");

            stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                employee.setId(rs.getInt(1));
            }

            System.out.println("#DB: The employee was successfully added in the database.");

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

    public static Employee getEmployee(String Username) {

        Employee employee = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM EMPLOYEE ")
                    .append("WHERE username = ").append("'").append(Username).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                employee = new Employee();

                employee.setId(res.getInt("id"));
                employee.setFirstname(res.getString("firstname"));
                employee.setLastname(res.getString("lastname"));
                employee.setUsername(res.getString("username"));
                employee.setPassword(res.getString("password"));
                employee.setEmail(res.getString("email"));

            } else {
                System.out.println("#DB: Employee with username " + Username + " was not found");
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

        return employee;

    }

}
