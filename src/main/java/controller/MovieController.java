package controller;

import Util.APIInfo;
import Util.JacksonHelper;
import dao.ReviewDao;
import dao.UserDao;
import model.FromAPI.Cast;
import model.FromAPI.Credit;
import model.FromAPI.Movie;
import model.FromAPI.Similar;
import model.Review;
import model.ReviewReturn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/movie/*"})
public class MovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // movie data
        String jsonMovieData = APIInfo.getApiData(APIInfo.getMoviePath(id));
        Movie movie = (Movie) JacksonHelper.mapToCorrespondingObject(jsonMovieData,Movie.class);

        // cast data
        String jsonMovieCastData = APIInfo.getApiData(APIInfo.getMovieCastPath(id));
        Credit credit = (Credit) JacksonHelper.mapToCorrespondingObject(jsonMovieCastData, Credit.class);
        List<Cast> casts = credit.getCast();

        //similar movies
        String jsonSimilarMoviesData = APIInfo.getApiData(APIInfo.getSimilarMoviePath(id));
        Similar similar = (Similar) JacksonHelper.mapToCorrespondingObject(jsonSimilarMoviesData, Similar.class);

        List<Movie> similar_movies = similar.getResults();
        HttpSession session = req.getSession();
        String movieId = req.getParameter("id");
        ReviewDao reviewDb = new ReviewDao();
        UserDao userDb = new UserDao();
        List<Review> listReview = reviewDb.getReviewByMovie(Integer.parseInt(movieId));
        List<ReviewReturn> returnList = new ArrayList<>();
        if (session.getAttribute("listReview") != null){
            returnList = (List<ReviewReturn>) session.getAttribute("listReview");
        }else{
            for (Review item: listReview) {
                ReviewReturn value = new ReviewReturn(item.getId(),item.getUserId(),item.getMovieId(), item.getDetailReview(),item.getShortReview(),item.getRate(), userDb.getUserById(item.getUserId()).getFullname());
                returnList.add(value);
            }
        }

        req.setAttribute("listReview", returnList);
        req.setAttribute("movie", movie);
        req.setAttribute("casts", casts);
        req.setAttribute("similar_movies", similar_movies);

        req.getRequestDispatcher("movieDetail.jsp").forward(req,resp);
    }
}
