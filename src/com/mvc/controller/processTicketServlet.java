package com.mvc.controller;

import javax.servlet.RequestDispatcher;
import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class processTicketServlet extends HttpServlet {
    public processTicketServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();







    }
}