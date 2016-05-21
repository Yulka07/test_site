package controllers;

import Security.MyEncryptor;
import crud.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import entity.User;
import org.apache.commons.lang3.CharSet;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;
/**
 * Created by Julia on 13.05.2016.
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            User user = new User();
            String mail = req.getParameter("mail");
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            String encryptedPass = MyEncryptor.getEncryptedPassword(password);

            user.setEmail(mail);
            user.setLogin(login);
            user.setPassword(encryptedPass);

            UserService dal = new UserService();

            if (dal.getByLogin(user.getLogin()) != null) {
                out.println("User with login " + req.getParameter("login") + " already exists!");
                out.println("<a href=\"register.jsp\">Try again...</a>");
            } else {
                dal.add(user);
                req.setAttribute("login", login);
                //req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
                resp.sendRedirect("/dashboard.jsp");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            out.close();
        }
    }
}

