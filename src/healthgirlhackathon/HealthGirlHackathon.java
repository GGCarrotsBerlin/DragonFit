/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthgirlhackathon;

//import com.sun.javaws.Main;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kerem
 */
public class HealthGirlHackathon extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Importing the image
        File image = new File("/Users/Kerem/Desktop/mario.png");
        Image imageStartPage = new Image(image.toURI().toString());
        
        //Displaying the image
        ImageView imageView = new ImageView();
        imageView.setImage(imageStartPage);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        //imageView.setSmooth(true);
        //imageView.setCache(true);
        
        Button btn = new Button();
        btn.setText("Continue");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SecondPage.display("Title", "Massage");
                primaryStage.close();
            }
        });
        
        HBox hBox = new HBox(10);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        
        VBox vBox = new VBox(10);
        vBox.getChildren().add(imageView);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(vBox);
        
        Scene scene = new Scene(borderPane, 700, 700);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
