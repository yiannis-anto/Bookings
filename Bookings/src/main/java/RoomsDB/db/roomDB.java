package RoomsDB.db;

import RoomsDB.model.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class roomDB {

    public static void addRoom(Room room) {

        Statement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = wholeDB.getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO ROOM")
                    .append("(name, maxcapacity, address, comforts, price, takendate)")
                    .append("VALUES (")
                    .append("'").append(room.getName()).append("',")
                    .append("'").append(room.getMaxCapacity()).append("',")
                    .append("'").append(room.getAddress()).append("',")
                    .append("'").append(room.getComforts()).append("',")
                    .append("'").append(room.getPrice()).append("',")
                    .append("'").append(room.getTakenDate()).append("');");

            stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                room.setId(rs.getInt(1));

            }

            System.out.println("#DB: The room was successfully added in the database.");

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

    public static Room getRoom(String name) {

        Room room = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM ROOM ")
                    .append("WHERE name = ").append("'").append(name).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                room = new Room();

                room.setName(res.getString("name"));
                room.setMaxCapacity(res.getInt("maxcapacity"));
                room.setAddress(res.getString("address"));
                room.setComforts(res.getString("comforts"));
                room.setPrice(res.getInt("price"));
                room.setTakenDate(res.getString("takendate"));

                room.setId(res.getInt("id"));


            } else {
                System.out.println("#DB: Room with name " + name + " was not found");
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

        return room;

    }

    public static Room getRoomById(int id) {

        Room room = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM ROOM ")
                    .append("WHERE id = ").append("'").append(id).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                room = new Room();

                room.setName(res.getString("name"));
                room.setMaxCapacity(res.getInt("maxcapacity"));
                room.setAddress(res.getString("address"));
                room.setComforts(res.getString("comforts"));
                room.setPrice(res.getInt("price"));
                room.setTakenDate(res.getString("takendate"));

                room.setId(res.getInt("id"));

            } else {
                System.out.println("#DB: Room with name " + id + " was not found");
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

        return room;

    }

    public static List<Room> getRooms() {

        List<Room> rooms = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM ROOM ");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Room room = new Room();

                room.setName(res.getString("name"));
                room.setMaxCapacity(res.getInt("maxcapacity"));
                room.setAddress(res.getString("address"));
                room.setComforts(res.getString("comforts"));
                room.setPrice(res.getInt("price"));
                room.setTakenDate(res.getString("takendate"));

                room.setId(res.getInt("id"));

                rooms.add(room);
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

        return rooms;

    }

    public static void updateRoom(Room room) {

        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE ROOM")
                    .append(" SET ")
                    .append("takendate = ").append("'").append(room.getTakenDate())
                    .append("' WHERE id = ").append(room.getId()).append(";");

            stmt.executeUpdate(sql.toString());

            System.out.println("#DB: The room was successfully updated in the database.");

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

    }

}
