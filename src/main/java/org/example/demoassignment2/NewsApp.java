package org.example.demoassignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class NewsApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        ListView<String> listView = new ListView<>();

        // Fetch the news articles
        JSONObject newsJson = APIUtility.fetchNews();
        if (newsJson != null) {
            JSONArray articles = newsJson.getJSONArray("articles");
            ArrayList<String> headlines = new ArrayList<>();

            // Parse articles and add to the list
            for (int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.getJSONObject(i);
                String headline = article.getString("title");
                headlines.add(headline);
            }

            // Display headlines in the ListView
            listView.getItems().addAll(headlines);
        }

        root.getChildren().add(listView);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("News Headlines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}