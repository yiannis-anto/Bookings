package Servlets;

import RoomsDB.db.personDB;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckUsernamePersonServlet", urlPatterns = {"/CheckUsernamePersonServlet"})
public class CheckUsernamePersonServlet extends HttpServlet {

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

        System.out.println("inside check person username servlet");
        String username = request.getParameter("username");
        System.out.println("The username is : " + username);
        Gson gson = new Gson();

        try {

            if (personDB.checkValidUsernamePerson(username)) {
                System.out.println("username okay person ");

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "200");
                jsonObject.addProperty("text", "username ok");
                String jsonString = gson.toJson(jsonObject);
                System.out.println("json: " + jsonString);

                PrintWriter out = response.getWriter();
                out.print(jsonObject);
                out.flush();

            } else {

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "400");
                jsonObject.addProperty("text", "username exists");
                String jsonString = gson.toJson(jsonObject);
                System.out.println("json: " + jsonString);

                PrintWriter out = response.getWriter();
                out.print(jsonObject);
                out.flush();

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckUsernamePersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckUsernamePersonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
