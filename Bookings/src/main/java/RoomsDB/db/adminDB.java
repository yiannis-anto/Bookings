package RoomsDB.db;

import RoomsDB.model.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class adminDB {

    public static void addAdmin(Admin admin) {

        Statement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO ADMIN")
                    .append("(firstname, lastname, username, password, email) ")
                    .append("VALUES (")
                    .append("'").append(admin.getFirstname()).append("',")
                    .append("'").append(admin.getLastname()).append("',")
                    .append("'").append(admin.getUsername()).append("',")
                    .append("'").append(admin.getPassword()).append("',")
                    .append("'").append(admin.getEmail()).append("');");

            stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                admin.setID(rs.getInt(1));
            }

            System.out.println("#DB: The admin was successfully added in the database.");

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

    public static Admin getAdmin(String Username) {

        Admin admin = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM ADMIN ")
                    .append("WHERE username = ").append("'").append(Username).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                admin = new Admin();

                admin.setUsername(res.getString("username"));
                admin.setPassword(res.getString("password"));
                admin.setEmail(res.getString("email"));
                admin.setLastname(res.getString("lastname"));
                admin.setFirstname(res.getString("firstname"));
                admin.setID(res.getInt("id"));

            } else {
                System.out.println("#DB: Account with username " + Username + " was not found");
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

        return admin;

    }
}
