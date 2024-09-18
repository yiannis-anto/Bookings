package Servlets;

import RoomsDB.db.reservationDB;
import RoomsDB.model.Reservation;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "confirmReservationServlet", urlPatterns = {"/confirmReservationServlet"})
public class confirmReservationServlet extends HttpServlet {

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

        String telephone = request.getParameter("telephone");

        System.out.println("The telephone is: " + telephone);

        Reservation reservation;

        reservation = reservationDB.getReservation(telephone);

        reservationDB.updateReservationToConfirmed(reservation);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status", "200");
        jsonObject.addProperty("text", "Reservation confirmed in DB");

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
