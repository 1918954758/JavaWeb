package net.zixue.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefreshServlet", urlPatterns = "/refresh")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "<meta http-equiv='refresh' content='3;url=/hello/home.html'>3秒后会自动跳转到首页，如果没有跳转，请点击<a href='/hello/home.html'>跳转链接</a>";
        request.setAttribute("message", message);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    private void Refresh1(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("refresh", "3;url='/hello/home.html'");
        response.getWriter().println("3秒后刷新");
    }
}
