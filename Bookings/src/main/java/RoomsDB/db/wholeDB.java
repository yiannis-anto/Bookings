package RoomsDB.db;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class wholeDB {

    private static final String URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "DB351";
    private static final int PORT = 3306;
    private static final String UNAME = "root";
    private static final String PASSWD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE + "?characterEncoding=UTF-8", UNAME, PASSWD);
    }

    public static void createDB() throws SQLException, ClassNotFoundException {
        System.out.println("Creating DB...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, UNAME, PASSWD);

        Statement stmt = con.createStatement();

        String sql = "CREATE DATABASE IF NOT EXISTS " + DATABASE;

        stmt.executeUpdate(sql);

        initDB();
        System.out.println("Database DB351 created...");
    }

    public static void initDB() throws SQLException, ClassNotFoundException {

        Statement stmt = null;
        Connection con = null;

        try {
            con = getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE TABLE IF NOT EXISTS ADMIN").append("(")
                    .append("id int AUTO_INCREMENT PRIMARY KEY,")
                    .append("firstname varchar(50) NOT NULL,")
                    .append("lastname varchar(50) NOT NULL,")
                    .append("username varchar(50) NOT NULL,")
                    .append("password varchar(50) NOT NULL,")
                    .append("email varchar(40) NOT NULL").append(")");

            stmt.executeUpdate(sql.toString());

            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS PERSON").append("(")
                    .append("id int AUTO_INCREMENT PRIMARY KEY,")
                    .append("birthdate varchar(50) NOT NULL,")
                    .append("firstname varchar(50) NOT NULL,")
                    .append("lastname varchar(50) NOT NULL,")
                    .append("email varchar(50) NOT NULL,")
                    .append("password varchar(50) NOT NULL,")
                    .append("telephone int NOT NULL,")
                    .append("username varchar(100) NOT NULL")
                    .append(")");

            stmt.executeUpdate(sql.toString());

            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS ROOM").append("(")
                    .append("id int AUTO_INCREMENT PRIMARY KEY,")
                    .append("name varchar(50) NOT NULL,")
                    .append("maxcapacity int NOT NULL,")
                    .append("address varchar(50) NOT NULL,")
                    .append("comforts varchar(100) NOT NULL,")
                    .append("price int NOT NULL,")
                    .append("takendate varchar(1000) NOT NULL")
                    .append(")");

            stmt.executeUpdate(sql.toString());

            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS RESERVATION").append("(")
                    .append("id int AUTO_INCREMENT PRIMARY KEY,")
                    .append("startdate varchar(10) NOT NULL,")
                    .append("fullname varchar(50) NOT NULL,")
                    .append("price int NOT NULL,")
                    .append("confirmed int NOT NULL,")
                    .append("roomid int NOT NULL,")
                    .append("telephone varchar(10) NOT NULL")
                    .append(")");

            stmt.executeUpdate(sql.toString());

            sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS EMPLOYEE").append("(")
                    .append("id int AUTO_INCREMENT PRIMARY KEY,")
                    .append("firstname varchar(20) NOT NULL,")
                    .append("lastname varchar(50) NOT NULL,")
                    .append("username varchar(50) NOT NULL,")
                    .append("password varchar(50) NOT NULL,")
                    .append("email varchar(50) NOT NULL")
                    .append(")");

            stmt.executeUpdate(sql.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void DropDB() throws SQLException, ClassNotFoundException {

        System.out.println("Deleting DB...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, UNAME, PASSWD);

        Statement stmt = con.createStatement();

        String sql = "DROP DATABASE " + DATABASE;

        stmt.executeUpdate(sql);

        System.out.println("Database DROPPED SUCCESFULLY...");
    }

}
