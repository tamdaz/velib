package fr.tamdaz.velib;

import java.io.IOException;
import java.net.URISyntaxException;

import fr.tamdaz.velib.services.Gateway;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

/**
 * Point d'entrée de l'application Velib;
 */
public class App extends Application {
    private static Scene scene;

    public static void main(String[] args) throws URISyntaxException, IOException {
        new Gateway().start();
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Vélib - App de disponibilités de vélos et bornes");
        stage.setMinWidth(1000);
        stage.setMinHeight(700);
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}