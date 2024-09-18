package Servlets;

import RoomsDB.db.reservationDB;
import RoomsDB.model.Reservation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "checkDateForReservationServlet", urlPatterns = {"/checkDateForReservationServlet"})
public class checkDateForReservationServlet extends HttpServlet {

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

        Gson gson = new Gson();

        String date = request.getParameter("date");
        String roomid = request.getParameter("id");
        System.out.println("The date is: " + date);
        System.out.println("The roomid is: " + roomid);

        Reservation res;
        res = reservationDB.getReservationByRoomId(Integer.parseInt(roomid));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonObject jsonObject = new JsonObject();
        int check = 0;

        if (res != null) {

            String[] datesofReservations = res.getStartdate().split(",", -2);

            for (String a : datesofReservations) {

                System.out.println(a);

                if (date.equals(a)) {

                    check = 1;

                    break;

                }

            }

            if (check == 1) {

                jsonObject.addProperty("status", "400");
                jsonObject.addProperty("text", "This room has Reservation");

            } else {

                jsonObject.addProperty("status", "200");
                jsonObject.addProperty("text", "This room has not Reservation");

            }

        } else {

            jsonObject.addProperty("status", "200");
            jsonObject.addProperty("text", "This room has not Reservation");

    }

    PrintWriter out = response.getWriter();

    out.print (jsonObject);

    out.flush ();


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
