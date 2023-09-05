package Controller;

import Model.DBConnection;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String even = request.getParameter("even");
        switch(even){
            case "add":
                  User newuser=new User(request.getParameter("username"), request.getParameter("email"),request.getParameter("password"));
                  newUser(newuser);
                break;
            case "update":
                break;
        }
    }

    public void newUser(User newuser) {
       new DBConnection().addUser(newuser);
    }
}