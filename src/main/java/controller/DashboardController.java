package controller;

import model.User;
import model.UserMovie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dashboard"})
public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<UserMovie> movieList = (List<UserMovie>) session.getAttribute("personalList");
        System.out.println(User.getWatchedList(movieList));
        System.out.println(User.getWillWatchList(movieList));
        req.setAttribute("watchedList", User.getWatchedList(movieList));
        req.setAttribute("willWatchList", User.getWillWatchList(movieList));
        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
    }
}
