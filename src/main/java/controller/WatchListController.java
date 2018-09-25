package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/watchlist")
public class WatchListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("movieId"));
        boolean add = Boolean.parseBoolean(req.getParameter("add"));

        HttpSession session = req.getSession();
        ArrayList<Integer> watchListIds = (ArrayList<Integer>) session.getAttribute("watchListIds");
        if (add)
        {
            if(!watchListIds.contains(id))
            {
                watchListIds.add(id);
            }
        }
        else
            watchListIds.remove(id);
        session.setAttribute("watchListIds", watchListIds);
        ObjectMapper mapper = new ObjectMapper();
        String returnedJSon = mapper.writeValueAsString(watchListIds);
        resp.getWriter().println(returnedJSon);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
