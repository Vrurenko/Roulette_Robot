package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Roulette Robot");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    @Override
    public void stop(){
    }

    @Override
    public void init(){
    }

    static void setStageTitle(String newTitle) {
        if (stage != null)
            stage.setTitle(newTitle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
