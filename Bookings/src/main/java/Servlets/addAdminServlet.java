package Servlets;

import RoomsDB.db.adminDB;
import RoomsDB.model.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addAdminServlet extends HttpServlet {

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

        Admin admin = new Admin();

        admin.setFirstname("Ioannis");
        admin.setLastname("A");
        admin.setPassword("123");
        admin.setUsername("admin");
        admin.setEmail("admin@looking.com");

        adminDB.addAdmin(admin);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
