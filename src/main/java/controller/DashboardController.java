package controller;

import Util.APIInfo;
import Util.JacksonHelper;
import dao.UserDao;
import model.FromAPI.Movie;
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
        List<Integer> watchListIds = (List<Integer>) session.getAttribute("watchListIds");
        UserDao userDb = new UserDao();
        req.setAttribute("userInfo", userDb.getUser((String) session.getAttribute("user")));

        List<Movie> watchlist = new ArrayList<>();

        for(Integer id : watchListIds)
        {
            String jsonMovieData = APIInfo.getApiData(APIInfo.getMoviePath(id.toString()));
            Movie movie = (Movie) JacksonHelper.mapToCorrespondingObject(jsonMovieData,Movie.class);
            watchlist.add(movie);
        }

        req.setAttribute("watchlist",watchlist);
        System.out.println(watchlist);

        session.setAttribute("page_title", "Dashboard");
        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
    }
}
