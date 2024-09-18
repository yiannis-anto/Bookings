package Servlets;

import RoomsDB.db.reservationDB;
import RoomsDB.model.Reservation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "getReservationsServlet", urlPatterns = {"/getReservationsServlet"})
public class getReservationsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Reservation> res = reservationDB.getReservations();
        JSONArray array = new JSONArray();

        for (Reservation item : res) {

            if (item.getConfirmed() == 1) {

                continue;
            }

            JSONObject json = new JSONObject();

            json.put("id", item.getId());
            json.put("date", item.getStartdate());
            json.put("fullname", item.getFullname());
            json.put("confirmed", item.getConfirmed());
            json.put("roomid", item.getRoomid());
            json.put("telephone", item.getTelephone());
            array.put(json);

        }

        PrintWriter out = response.getWriter();
        out.print(array);
        out.flush();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
