package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Discover;
import model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet({""})
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpURLConnection conn = null;
            BufferedReader reader = null;
            URL url = new URL(APIInfo.apiBaseUrl);
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
//            System.out.println("API return" + strBuf.toString());

            ObjectMapper objectMapper = new ObjectMapper();

            //convert json string to object
            Discover discover = objectMapper.readValue(strBuf.toString(), Discover.class);
            List<Movie> movies = discover.getResults();
            Movie mainBannerMovie = movies.get(0);
            movies.remove(0);
            System.out.println(mainBannerMovie);

            int numberOfElements = 3;

            List<Movie> subBannerMovies = new ArrayList<Movie>();
            Random rand = new Random();
            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(movies.size());
                subBannerMovies.add(movies.get(randomIndex)) ;
                movies.remove(randomIndex);
            }

            for (Movie m: subBannerMovies)
                System.out.println(m);

            System.out.println(mainBannerMovie.getOriginal_title());

            conn.disconnect();
            req.setAttribute("mainBannerMovie", mainBannerMovie);
            req.setAttribute("subBannerMovies", mainBannerMovie);

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
