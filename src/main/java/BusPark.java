import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BusPark extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("База водителей");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
