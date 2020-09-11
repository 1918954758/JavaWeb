package net.zixue.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @ClassName HelloServlet
 * @Discription 简单的servlet
 * @Author 子辰
 * @Date 2020/9/12 1:07
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是doGet方法");
        System.out.println("请求方式：" + req.getMethod());
        System.out.println("URI：" + req.getRequestURI());
        System.out.println("发出请求客户端的IP地址：" + req.getRemoteAddr());
        System.out.println("服务点接收请求的IP地址：" + req.getLocalAddr());
        System.out.println("访问客户端的端口号：" + req.getRemotePort());
        System.out.println("web应用路径：" + req.getContextPath());
        System.out.println("heep协议和版本：" + req.getProtocol());
        /**
         * 我是doGet方法
         * 请求方式：GET
         * URI：/hello/hi
         * 发出请求客户端的IP地址：0:0:0:0:0:0:0:1
         * 服务点接收请求的IP地址：0:0:0:0:0:0:0:1
         * 访问客户端的端口号：65110
         * web应用路径：/hello
         * heep协议和版本：HTTP/1.1*/

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>使用HTTPServletRequst获取请求头内容<<<<<<<<<<<<<<<<<<<<<<<");
        /**
         * host
         * connection
         * cache-control
         * upgrade-insecure-requests
         * user-agent
         * accept
         * accept-encoding
         * accept-language
         */
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();

            // host：localhost:8080
            // connection：keep-alive
            // cache-control：max-age=0
            // upgrade-insecure-requests：1
            // user-agent：Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3371.0 Safari/537.36
            // accept：text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
            // accept-encoding：gzip, deflate, br
            // accept-language：zh-CN,zh;q=0.9
            System.out.println(s + "：" + req.getHeader(s));
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>使用HTTPServletRequst获取参数<<<<<<<<<<<<<<<<<<<<<<<");
        String name = req.getParameter("name");
        String passWord = req.getParameter("passWord");
        System.out.println("name:" + name);
        System.out.println("passWord:" + passWord);

        String result = "恭喜您登录成功";
        /*
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(result.getBytes());
        */
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是doPost方法");
    }
}
