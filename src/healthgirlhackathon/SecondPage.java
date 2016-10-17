/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthgirlhackathon;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Kerem
 */
public class SecondPage {
    
        public static void display(String title, String message){
         Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Acilan Pencerenin Basligi");
        window.setMinWidth(250);
        window.setMinHeight(350);

        //Importing the image
        File image = new File("/Users/Kerem/Documents/Programlamalar/DragonFit/dragon.png");
        Image imageStartPage = new Image(image.toURI().toString());
        
        //Displaying the image
        ImageView imageView = new ImageView();
        imageView.setImage(imageStartPage);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        //imageView.setSmooth(true);
        //imageView.setCache(true);
        
        //Declaring the Textarea
        TextArea textArea_name = new TextArea();
        textArea_name.setMaxWidth(200);
        textArea_name.setMaxHeight(20);
        TextArea textArea_pass = new TextArea();
        textArea_pass.setMaxWidth(200);
        textArea_pass.setMaxHeight(20);
        
        
        //Setting the prompt Text
        textArea_name.setPromptText("Enter your Name");
        textArea_pass.setPromptText("Enter your Pass");

    
        Button closeButton = new Button("Close The Window!");
        closeButton.setOnAction(e -> window.close());

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 //Dashboard(2);
                 Dashboard.display("Title", "Massage");
             }
         });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(imageView);
        vBox.setAlignment(Pos.CENTER);
    
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(confirmButton, closeButton);
    
    
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(30));
        grid.getChildren().addAll(imageView, textArea_name, textArea_pass, hBox);
        GridPane.setConstraints(imageView, 1, 0);
        GridPane.setConstraints(textArea_name, 1, 1);
        GridPane.setConstraints(textArea_pass, 1, 2);
        GridPane.setConstraints(hBox, 1, 3);
        //GridPane.setConstraints(confirmButton, 2, 3);
        //GridPane.setConstraints(closeButton, 1, 3);
        
        
        
    Scene scene = new Scene(grid, 700, 700);
    window.setScene(scene);
    scene.getStylesheets().add("healthgirlhackathon/newThema.css");    
    window.showAndWait();
    

    }
    
    
}
