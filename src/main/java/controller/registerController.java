package controller;

import Util.EmailHelper;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet({"/register"})
public class registerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String address = req.getParameter("address");
        String fullName = req.getParameter("fullName");
        String telephone = req.getParameter("telephone");
        if (!EmailHelper.isValid(user)){
            throw new IllegalArgumentException("Invalid Email");
        }
        UserDao userDb = new UserDao();
        if (userDb.addUser(user,pass,fullName,telephone,address)){
            session.setAttribute("user", user);
            resp.getWriter().write("/");
        }

    }
}
