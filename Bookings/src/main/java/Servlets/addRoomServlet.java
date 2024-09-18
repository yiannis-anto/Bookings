package Servlets;

import RoomsDB.db.roomDB;
import RoomsDB.model.Room;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addRoomServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Room room = new Room();

        room.setName("aithousa 1");
        room.setMaxCapacity(400);
        room.setAddress("Turtaiou 22");
        room.setComforts("Good Sound and light");
        room.setPrice(200);
        room.setTakenDate("-");


        roomDB.addRoom(room);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
