/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

@WebServlet(name = "addPersonToDBServlet", urlPatterns = {"/addPersonToDBServlet"})
public class addPersonToDBServlet extends HttpServlet {

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

        System.out.println("inside add person to db servlet");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String birthday = request.getParameter("birthday");

        System.out.println("The username is: " + username);
        System.out.println("The password is: " + password);
        System.out.println("The firstname is: " + firstname);
        System.out.println("The lastname is: " + lastname);
        System.out.println("The email is: " + email);
        System.out.println("The telephone is: " + telephone);
        System.out.println("The birthday is: " + birthday);

        Gson gson = new Gson();

        Person person = new Person();

        person.setUsername(username);
        person.setPassword(password);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setEmail(email);
        person.setTelephone(Integer.parseInt(telephone));
        person.setBirthdate(birthday);

        personDB.addPerson(person);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (personDB.getPerson(username) != null) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "200");
            jsonObject.addProperty("text", "person added in DB");


            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();

        } else {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "400");
            jsonObject.addProperty("text", "Error!!! Person not added in DB");
            String jsonString = gson.toJson(jsonObject);

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
