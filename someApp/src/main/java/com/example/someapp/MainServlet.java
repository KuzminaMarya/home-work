package com.example.someapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {

    private volatile int Counter=0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Counter = (int) session.getAttribute("Counter");
        if (Counter == 0) {
            Counter = 1;
        } else {
            Counter++;
        }
        session.setAttribute("Counter", Counter);
        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (name == null) {
            printWriter.write("Hello, Anonymous" + "<br>");
        } else {
            printWriter.write("Hello, " + name + "<br>");
        }
        printWriter.write("Counter =  " + Counter);
        printWriter.close();
    }
}
