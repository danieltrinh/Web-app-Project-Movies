package Util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIInfo {
    public static final String apiKey = "132df4c1e5f3c8f5022c2e5a94fedce4";
    public static final String apiBaseUrl = "https://api.themoviedb.org/3/";

    public static String getApiData(String requestUrl) {
        try {
            HttpURLConnection conn = null;
            BufferedReader reader = null;
            URL url = new URL(requestUrl);
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
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder strBuf = new StringBuilder();
            while ((output = reader.readLine()) != null)
                strBuf.append(output);

            conn.disconnect();

            return strBuf.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getNodeFromJson(String fullJson, String nodeName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(fullJson);

            JsonNode locatedNode = rootNode.path(nodeName);

            return locatedNode.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDiscoverPath() {
        return apiBaseUrl + "discover/movie?api_key=" + apiKey;
    }

    public static String getMoviePath(String id) {
        return apiBaseUrl + "movie/" + id + "?api_key=" + apiKey;
    }

    public static String getMovieCastPath(String id) {
        return apiBaseUrl + "movie/" + id + "/credits" + "?api_key=" + apiKey;
    }

    public static String getSimilarMoviePath(String id){
        return apiBaseUrl+ "movie/" + id + "/similar?api_key=" + apiKey;
    }
}
