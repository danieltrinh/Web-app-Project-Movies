package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/test"})
public class TestController extends HttpServlet {
    private static final String apiKey = "";
    private static final String apiBaseUrl = "https://api.themoviedb.org/3/movie/177572/credits?api_key=132df4c1e5f3c8f5022c2e5a94fedce4";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Test initial for project");
    }

    public void runTest()
    {
        System.out.println("sadas");
//        try {
//            HttpURLConnection conn = null;
//            BufferedReader reader = null;
//            URL url = new URL(apiBaseUrl);
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
////            conn.setRequestProperty("api_key", apiKey);
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//            System.out.println("asda");
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            //convert json string to object
//            Movie mov = objectMapper.readValue(output, Movie.class);
//            conn.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
