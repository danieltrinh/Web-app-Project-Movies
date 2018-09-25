package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/watchlist")
public class WatchListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("movieId"));
        boolean add = Boolean.parseBoolean(req.getParameter("add"));

        HttpSession session = req.getSession();
        List<Integer> watchListIds = (List<Integer>) session.getAttribute("watchListIds");
        if(watchListIds.contains(id))
        {
            if(add)
                watchListIds.add(id);
            else
                watchListIds.remove(id);
        }
        session.setAttribute("watchListIds", watchListIds);
        ObjectMapper mapper = new ObjectMapper();
        String returnedJSon = mapper.writeValueAsString(watchListIds);
        resp.getWriter().println();
    }
}
