/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import RoomsDB.db.roomDB;
import RoomsDB.model.Room;
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

@WebServlet(name = "getRoomsServlet", urlPatterns = {"/getRoomsServlet"})
public class getRoomsServlet extends HttpServlet {

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


        List<Room> rooms = roomDB.getRooms();
        JSONArray array = new JSONArray();

        for (Room item : rooms) {

            JSONObject json = new JSONObject();

            json.put("id", item.getId());
            json.put("name", item.getName());
            json.put("MaxCapacity", item.getMaxCapacity());
            json.put("Address", item.getAddress());
            json.put("getComforts", item.getComforts());
            json.put("Price", item.getPrice());
            json.put("TakenDate", item.getTakenDate());
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
