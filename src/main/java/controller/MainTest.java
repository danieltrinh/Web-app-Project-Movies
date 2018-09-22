package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Discover;
import model.Movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTest {
    private static final String apiKey = "";
    private static final String apiBaseUrl = "https://api.themoviedb.org/3/discover/movie?api_key=132df4c1e5f3c8f5022c2e5a94fedce4";

    public static void main(String args[]) {
        try {
            HttpURLConnection conn = null;
            BufferedReader reader = null;
            URL url = new URL(apiBaseUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            // get return json
            String output = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            StringBuilder strBuf = new StringBuilder();
            while ((output = reader.readLine()) != null)
                strBuf.append(output);
            System.out.println("API return" + strBuf.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            //convert json string to object
            Discover discover = objectMapper.readValue(strBuf.toString(), Discover.class);
            List<Movie> movies = discover.getResults();
            Movie mainBannerMovie = movies.get(0);
            System.out.println(mainBannerMovie);

            int numberOfElements = 3;

            List<Movie> subBannerMovies = new ArrayList<Movie>();
            Random rand = new Random();
            for (int i = 1; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(movies.size());
                subBannerMovies.add(movies.get(randomIndex)) ;
                movies.remove(randomIndex);
            }

            System.out.println(mainBannerMovie.getOriginal_title());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
