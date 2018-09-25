package controller;

import Util.APIInfo;
import Util.JacksonHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import model.FromAPI.Cast;
import model.FromAPI.Credit;
import model.FromAPI.Movie;
import model.FromAPI.Similar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    private static final String apiKey = "132df4c1e5f3c8f5022c2e5a94fedce4";
    private static final String apiBaseUrl = "https://api.themoviedb.org/3/discover/movie?api_key=132df4c1e5f3c8f5022c2e5a94fedce4";

    public static void main(String args[]) {
        UserDao userDb = new UserDao();
        ArrayList<Integer> watchListIds = userDb.getUser("son@mum.edu").getWatchListIds();

        List<Movie> watchlist = new ArrayList<>();

        for(Integer id : watchListIds)
        {
            String jsonMovieData = APIInfo.getApiData(APIInfo.getMoviePath(id.toString()));
            Movie movie = (Movie) JacksonHelper.mapToCorrespondingObject(jsonMovieData,Movie.class);
            watchlist.add(movie);
        }

        System.out.println(watchlist);
        // movie data


    }
}
