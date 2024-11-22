package org.example.demoassignment2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class APIUtility {
    private static final String API_KEY = "d88fce22a579421d8c5cb38d188fcac9";
    private static final String API_URL = "https://newsapi.org/v2/everything?q=technology&apiKey=" + API_KEY;

    public static JSONObject fetchNews() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new JSONObject(response.toString());  // Parse the JSON response
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
