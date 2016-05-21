package controllers;

import Security.MyEncryptor;
import crud.UserService;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Julia on 13.05.2016.
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService dal = new UserService();

        User user = dal.getByLogin(login);
        try {
            if (user != null && user.getPassword().equals(MyEncryptor.getEncryptedPassword(password))) {
                req.setAttribute("login", login);
                req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Either username or password is incorrect!");
                out.println("<a href= \"login.jsp\">Try again...</a>");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
