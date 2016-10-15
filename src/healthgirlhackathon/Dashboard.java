/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthgirlhackathon;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
  @author Kerem
 */
public class Dashboard {
    
        public static void display(String title, String message){
         Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Acilan Pencerenin Basligi");
        window.setMinWidth(250);
        window.setMinHeight(350);

        final Label label_sync = new Label();
        label_sync.setText("The data is being synchronized");
        label_sync.setVisible(false);

        Button button_sync = new Button("Synchronisieren");
        button_sync.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 label_sync.setVisible(true);
//                 try {
//                     Thread.sleep(2000);
//                     label_sync.setVisible(false);                                      
//                 } catch (InterruptedException ex) {
//                     Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//                 }
             }
         });
        
        Label label_Name = new Label();
        label_Name.setText("DASHBOARD");
        
        //Here we need the pie
        
        //Here is the name of the player  ###LAter we need to get it from the previous entrence
        Label label_name_of_the_player = new Label();
        label_name_of_the_player.setText("Reizz");
        
        Label label_age_of_the_dragon = new Label();
        label_age_of_the_dragon.setText("__");
        
        Label label_age_of_the_emotion = new Label();
        label_age_of_the_emotion.setText("__% ready");
        
        Label label_age_of_the_domination = new Label();
        label_age_of_the_domination.setText("for world domination");
     
        
        HBox hBox_above = new HBox(10);
        hBox_above.getChildren().addAll(label_sync, button_sync);
        
        //Add into those: LAbel, Pie, Name, Age, Emotion, "String" Domination
        VBox vBox_left_side = new VBox(10);
        vBox_left_side.getChildren().addAll(label_age_of_the_domination, label_age_of_the_dragon, label_age_of_the_emotion, label_name_of_the_player);
        vBox_left_side.setPadding(new Insets(15));
        vBox_left_side.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();
        BorderPane borderPane_general = new BorderPane();
        borderPane_general.setTop(hBox_above);
        borderPane_general.setLeft(vBox_left_side);
    
        Scene scene = new Scene(borderPane_general, 700, 700);
        window.setScene(scene);
        window.showAndWait();


    }
    
}
