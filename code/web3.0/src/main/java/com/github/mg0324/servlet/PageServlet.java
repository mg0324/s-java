package com.github.mg0324.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: mango
 * @Date: 2022/12/30 3:18 PM
 */
@WebServlet("/test/HttpServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("hello HttpServlet!!!");
        /**
         * <!DOCTYPE html>
         * <html>
         * <head>
         * <meta charset="UTF-8">
         * <title>servlet页面</title>
         * </head>
         * <body>
         * 	这是我的第一个servlet页面。
         * </body>
         * </html>
         */
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>servlet页面</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("这是我的第一个servlet页面");
        writer.println("</body>");
        writer.println("</html>");
    }
}
