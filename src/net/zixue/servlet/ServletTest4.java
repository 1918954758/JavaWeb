package net.zixue.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletTest4", urlPatterns = "/test4")
public class ServletTest4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这个时放在web下面的写法,一般放在web目录下
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/db.properties");
        //这个时放在src下的下发
        InputStream resourceAsStream1 = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String name = properties.getProperty("name");
        String url = properties.getProperty("url");
        String passWord = properties.getProperty("passWord");
        System.out.println(name);
        System.out.println(url);
        System.out.println(passWord);
    }
}
