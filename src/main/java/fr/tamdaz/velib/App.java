package fr.tamdaz.velib;

import java.io.IOException;

import fr.tamdaz.velib.services.Gateway;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

/**
 * Application Vélib.
 */
public class App extends Application {
    private static Scene scene;

    /**
     * Point d'entrée de l'application.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Gateway.start();
        launch();
    }

    /**
     * Permet de lancer l'application graphique.
     */
    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Vélib - App de disponibilités de vélos et bornes");
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    /**
     * Méthode qui permet de définir le fichier FXML à charger pour la vue.
     * 
     * @param fxml Fichier FXML
     * @throws IOException
     */
    protected static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Méthode statique qui permet de charger la vue.
     * 
     * @param fxml Fichier FXML
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}