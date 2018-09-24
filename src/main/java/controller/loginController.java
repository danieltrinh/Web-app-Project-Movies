package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/login"})
public class loginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String remember = req.getParameter("remember");

        UserDao userDb = new UserDao();

        if (userDb.checkExistUser(user, pass)) {
            if (remember != null) {
                Cookie cookie = new Cookie("user", user);
                cookie.setMaxAge(30 * 24 * 60 * 60); //in seconds
                resp.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("user", user);
                cookie.setMaxAge(0); //in seconds
                resp.addCookie(cookie);
            }
            session.setAttribute("user", user);
            session.setAttribute("userId", userDb.getUser(user).getId());
            session.setAttribute("watchListIds", userDb.getUser(user).getWatchListIds());
            String urlToRedirect = "dashboard";
            resp.getWriter().write(urlToRedirect);
        } else {
            session.setAttribute("message", "Username or password is wrong");

        }
    }
}
