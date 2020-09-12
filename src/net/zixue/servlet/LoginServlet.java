package net.zixue.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = "lemon";
        String userPassWord = "520";
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        if(!name.equals(userName)){
            //账户不存在
            request.setAttribute("errMessage", "账户不存在");
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
        }else if(!passWord.equals(userPassWord)){
            //密码错误
            request.setAttribute("errMessage", "密码错误");
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
        } else {
            //账号密码正确
            /*response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "https://www.baidu.com");*/
            //response.sendRedirect("https://www.jd.com");
            //response.sendRedirect("home.html");
            response.sendRedirect("/hello/home.html");
        }
    }
}
