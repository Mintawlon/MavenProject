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
                 request.getRequestDispatcher("dataList.jsp").forward(request,response);
                break;
            case "update":

                break;
        }
    }

    public void newUser(User newuser) {
       new DBConnection().addUser(newuser);

    }
    // for update user data
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String getData = request.getParameter("getData");
        switch(getData){
            case "update":

                break;
        }
    }

}