package com.mvc.controller;

import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SigninServlet extends HttpServlet {
    public SigninServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //System.out.println(email + " " + password);

        RegisteredUser user = new RegisteredUser();


        boolean validate = user.login(email, password);
        if(validate){
            user.retrieveUsersData(email);
            HttpSession session=request.getSession();
            session.setAttribute("email",email);
            session.setAttribute("name", user.getFNAME());
            session.setMaxInactiveInterval(600);
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
        }
        else{
            out.print("Sorry username or password error");
            RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
            rd.include(request,response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }
}
