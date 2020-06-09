package main;

import dao.database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main_tela_principal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_tela_principal.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/tela_principal.css");
        primaryStage.setTitle("Minha Agenda");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("main/agenda.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
