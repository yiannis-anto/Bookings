package Servlets;

import RoomsDB.db.personDB;
import RoomsDB.model.Person;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginGuestServlet", urlPatterns = {"/loginGuestServlet"})
public class loginGuestServlet extends HttpServlet {

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("The username is: " + username);
        System.out.println("The password is: " + password);

        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonObject jsonObject = new JsonObject();


        Person person;
        person = personDB.getPerson(username);


        if (person != null) {
            String password1 = person.getPassword();
            if (password1.equals(password)) {
                System.out.println("all ok");
                    jsonObject.addProperty("status", "200");
                    jsonObject.addProperty("username", username);
                } else {
                    System.out.println("edw");
                    jsonObject.addProperty("status", "400");
                    jsonObject.addProperty("text", "User doesnt exist.");

                }

        } else {

            jsonObject.addProperty("status", "400");
            jsonObject.addProperty("text", "User doesnt exist.");
        }

        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
