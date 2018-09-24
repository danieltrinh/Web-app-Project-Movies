package controller;

import Util.APIInfo;
import Util.JacksonHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.FromAPI.Cast;
import model.FromAPI.Credit;
import model.FromAPI.Movie;
import model.FromAPI.Similar;

import java.util.List;

public class MainTest {
    private static final String apiKey = "132df4c1e5f3c8f5022c2e5a94fedce4";
    private static final String apiBaseUrl = "https://api.themoviedb.org/3/discover/movie?api_key=132df4c1e5f3c8f5022c2e5a94fedce4";

    public static void main(String args[]) {

        String id = "348350";

        String dataFromAPI = APIInfo.getApiData(APIInfo.getSimilarMoviePath(id));
        System.out.println(APIInfo.getSimilarMoviePath(id));
//        String castData = APIInfo.getNodeFromJson(dataFromAPI,"cast");

//        Credit credit = (Credit) JacksonHelper.mapToCorrespondingObject(dataFromAPI, Credit.class);
//
//        List<Cast> casts = credit.getCast();

        Similar similar = (Similar) JacksonHelper.mapToCorrespondingObject(dataFromAPI, Similar.class);

        List<Movie> similar_movies = similar.getResults();

        System.out.println(similar_movies);
    }
}
