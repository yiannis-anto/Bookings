/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import RoomsDB.db.reservationDB;
import RoomsDB.db.roomDB;
import RoomsDB.model.Reservation;
import RoomsDB.model.Room;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addReservationServlet", urlPatterns = {"/addReservationServlet"})
public class addReservationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String date = request.getParameter("date");
        String fullname = request.getParameter("fullname");
        String telephone = request.getParameter("telephone");
        String roomid = request.getParameter("roomid");
        String price = request.getParameter("price");

        System.out.println("Date: " + date);
        System.out.println("fullname: " + fullname);
        System.out.println("telephone: " + telephone);
        System.out.println("roomid: " + roomid);
        System.out.println("price: " + price);

        Reservation res = new Reservation();

        res.setStartdate(date);
        res.setFullname(fullname);
        res.setConfirmed(0);
        res.setTelephone(telephone);
        res.setPrice(Integer.parseInt(price));
        res.setRoomid(Integer.parseInt(roomid));

        reservationDB.addReservation(res);
        Room room;

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (reservationDB.getReservation(telephone) != null) {

            room = roomDB.getRoomById(Integer.parseInt(roomid));

            String takenDates = room.getTakenDate();

            takenDates += "," + date;

            room.setTakenDate(takenDates);

            roomDB.updateRoom(room);


            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "200");
            jsonObject.addProperty("text", "Reservation added in DB");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();

        } else {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "400");
            jsonObject.addProperty("text", "Error!!! Reservation not added in DB");

            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
        }


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
