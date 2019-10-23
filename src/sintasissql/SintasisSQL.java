/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintasissql;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ayax9
 */
public class SintasisSQL extends Application {

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent proyecto = FXMLLoader.load(getClass().getResource("/Views/SintaxisList.fxml"));
        Scene semaforo = new Scene(proyecto);

        primaryStage.setScene(semaforo);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
