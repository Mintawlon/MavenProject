package Controller;

import Model.DBConnection;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "Testing", value = "/Testing")
public class Testing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        switch(page){

            case "home":
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                break;
            case "userData":
                    UserList(request,response);
                break;
            case "add":
                request.getRequestDispatcher("addUser.jsp").forward(request,response);
                break;
            default:

        }

    }
    public void UserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<User> lister= new DBConnection().UserData();
        request.setAttribute("userdata", lister);
        request.getRequestDispatcher("dataList.jsp").forward(request,response);
    }

}