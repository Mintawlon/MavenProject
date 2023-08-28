package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.*;

import java.io.IOException;

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
                  request.getRequestDispatcher("dataList.jsp").forward(request,response);
                break;

            default:

        }

    }

}