package ru.browser.app.browser;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class JavaFxBrowser extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        TextField urlField = new TextField("https://www.google.com");
        Button goButton = new Button("Перейти");
        Button backButton = new Button("Назад");
        Button forwardButton = new Button("Вперед");
        HBox.setMargin(backButton, new Insets(5, 0, 0, 5));
        HBox.setMargin(goButton, new Insets(5, 0, 0, 2));
        HBox.setMargin(forwardButton, new Insets(5, 0, 0, 2));
        HBox.setMargin(urlField, new Insets(5, 0, 0, 5));

        HBox.setHgrow(urlField, Priority.ALWAYS);

        HBox buttonBox = new HBox(backButton, forwardButton);
        buttonBox.setSpacing(5);

        HBox urlBox = new HBox(urlField, goButton);
        urlBox.setSpacing(5);

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        WebHistory history = webEngine.getHistory();

        goButton.setOnAction(e -> {
            String url = urlField.getText();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            webEngine.load(url);
        });

        backButton.setOnAction(e -> {
            if (history.getCurrentIndex() > 0) {
                history.go(-1);
            }
        });

        forwardButton.setOnAction(e -> {
            if (history.getCurrentIndex() < history.getEntries().size() - 1) {
                history.go(1);
            }
        });

        webView.getEngine().setCreatePopupHandler(config -> {
            primaryStage.show();
            return null;
        });

        root.setTop(new VBox(urlBox, buttonBox));
        root.setCenter(webView);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Браузер");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
