package net.zixue.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "VerifyCodeServlet", urlPatterns = "/code")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();//获取绘图对象
        graphics.setColor(Color.gray);//验证码颜色
        graphics.fillRect(0, 0, width, height);//验证码图片的坐标

        String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321abcdefghijklmnopqrstuvwxyz";
        graphics.setColor(Color.black);
        Random random = new Random();
        for(int i = 0; i < 4; i++) {
            int position = random.nextInt(data.length());
            String str = data.split("")[position];
            graphics.drawString(str, width/5 * (i + 1), 15);
        }
        //将图片格式化输出到流中
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
