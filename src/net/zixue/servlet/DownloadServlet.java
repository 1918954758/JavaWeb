package net.zixue.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //如何将服务器上的资源返回给浏览器
        //response.getWriter();//输出字节码文件
        String filename = request.getParameter("filename");

        //通知浏览器不要预览，直接下载
        String initParameter = this.getServletContext().getInitParameter(filename);
        response.setContentType(initParameter);
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        //获取文件的绝对路径
        String realPath = this.getServletContext().getRealPath("/download/" + filename);
        InputStream in = in = new FileInputStream(realPath);
//        try {
//
//        } catch (FileNotFoundException e){
//            request.getRequestDispatcher("/sourcesNotExsist.html").forward(request, response);
//        }
        ServletOutputStream outputStream = response.getOutputStream();//输出二进制文件

        //文件拷贝
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0){
            outputStream.write(buffer, 0, len);
        }
        in.close();
        //outputStream.close();  不需要手动关闭，因为是从servlet中获取的

    }
}
