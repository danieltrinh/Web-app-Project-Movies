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

//        String id = "348350";

//        String dataFromAPI = APIInfo.getApiData(APIInfo.getSimilarMoviePath(id));
//        System.out.println(APIInfo.getSimilarMoviePath(id));
//        String castData = APIInfo.getNodeFromJson(dataFromAPI,"cast");

//        Credit credit = (Credit) JacksonHelper.mapToCorrespondingObject(dataFromAPI, Credit.class);
//
//        List<Cast> casts = credit.getCast();

//        Similar similar = (Similar) JacksonHelper.mapToCorrespondingObject(dataFromAPI, Similar.class);

//        List<Movie> similar_movies = similar.getResults();

//        System.out.println(similar_movies);

        Integer id =270691;
        boolean add = false;
        UserDao userDb = new UserDao();
        ArrayList<Integer> watchListIds = userDb.getUser("son@mum.edu").getWatchListIds();
        if(add)
            watchListIds.add(id);
        else
            watchListIds.remove(id);

//        session.setAttribute("watchListIds", watchListIds);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String returnedJSon = mapper.writeValueAsString(watchListIds);
            System.out.println(returnedJSon);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
//        resp.getWriter().println(returnedJSon);
    }
}
