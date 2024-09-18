package RoomsDB.db;

import RoomsDB.model.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class reservationDB {

    public static void addReservation(Reservation reservation) {

        Statement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO RESERVATION")
                    .append("(startdate, fullname, price, confirmed, roomid, telephone) ")
                    .append("VALUES (")
                    .append("'").append(reservation.getStartdate()).append("',")
                    .append("'").append(reservation.getFullname()).append("',")
                    .append("'").append(reservation.getPrice()).append("',")
                    .append("'").append(reservation.getConfirmed()).append("',")
                    .append("'").append(reservation.getRoomid()).append("',")
                    .append("'").append(reservation.getTelephone()).append("');");


            stmt.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                reservation.setId(rs.getInt(1));
            }

            System.out.println("#DB: The reservation was successfully added in the database.");

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

    public static Reservation getReservation(String tel) {

        Reservation reservation = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM RESERVATION ")
                    .append("WHERE telephone = ").append("'").append(tel).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                reservation = new Reservation();

                reservation.setId(res.getInt("id"));
                reservation.setStartdate(res.getString("startdate"));
                reservation.setFullname(res.getString("fullname"));
                reservation.setPrice(res.getInt("price"));

                reservation.setConfirmed(res.getInt("confirmed"));

                reservation.setRoomid(res.getInt("roomid"));

                reservation.setTelephone(res.getString("telephone"));


            } else {
                System.out.println("#DB: Reservation with telephone " + tel + " was not found"
                );
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

        return reservation;

    }

    public static Reservation getReservationByRoomId(int roomid) {

        Reservation reservation = null;
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM RESERVATION ")
                    .append("WHERE id = ").append("'").append(roomid).append("';");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                reservation = new Reservation();

                reservation.setId(res.getInt("id"));
                reservation.setStartdate(res.getString("startdate"));
                reservation.setFullname(res.getString("fullname"));
                reservation.setPrice(res.getInt("price"));

                reservation.setConfirmed(res.getInt("confirmed"));

                reservation.setRoomid(res.getInt("roomid"));

                reservation.setTelephone(res.getString("telephone"));

            } else {
                System.out.println("#DB: Reservation with roomid " + roomid + " was not found"
                );
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

        return reservation;

    }

    public static List<Reservation> getReservations() {

        List<Reservation> reservations = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT * FROM RESERVATION");

            stmt.execute(sql.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {

                Reservation reser = new Reservation();

                reser.setStartdate(res.getString("startdate"));
                reser.setFullname(res.getString("fullname"));
                reser.setTelephone(res.getString("telephone"));
                reser.setPrice(res.getInt("price"));
                reser.setConfirmed(res.getInt("confirmed"));
                reser.setRoomid(res.getInt("roomid"));
                reser.setId(res.getInt("id"));

                reservations.add(reser);
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

        return reservations;

    }

    public static void updateReservationToConfirmed(Reservation reservation) {

        Statement stmt = null;
        Connection con = null;

        try {

            con = wholeDB.getConnection();
            stmt = con.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("UPDATE RESERVATION")
                    .append(" SET ")
                    .append("confirmed = ").append(1)
                    .append(" WHERE id = ").append(reservation.getId()).append(";");

            stmt.executeUpdate(sql.toString());

            System.out.println("#DB: The reservation was successfully updated in the database.");

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
