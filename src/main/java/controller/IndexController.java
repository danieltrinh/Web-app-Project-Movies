package controller;

import Util.APIInfo;
import Util.JacksonHelper;
import model.FromAPI.Discover;
import model.FromAPI.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet({""})
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String jsonFromApi = APIInfo.getApiData(APIInfo.getDiscoverPath());

            Discover discover = (Discover)JacksonHelper.mapToCorrespondingObject(jsonFromApi, Discover.class);

            List<Movie> movies = discover.getResults();
            Movie mainBannerMovie = movies.get(0);
            movies.remove(0);
            System.out.println(mainBannerMovie);

            int numberOfElements = 3;

            List<Movie> subBannerMovies = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(movies.size());
                subBannerMovies.add(movies.get(randomIndex)) ;
                movies.remove(randomIndex);
            }

            for (Movie m : subBannerMovies) {
                System.out.println(m.getOriginal_title());
                System.out.println(m.getOverview());
                System.out.println(m.getBackdrop_path());
            }

            req.setAttribute("mainBannerMovie", mainBannerMovie);
            req.setAttribute("subBannerMovies", subBannerMovies);

        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("user"));

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
