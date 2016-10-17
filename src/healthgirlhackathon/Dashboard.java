/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthgirlhackathon;

import com.sun.prism.impl.Disposer.Record;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.netbeans.modules.java.source.engine.FileSourceRewriter;


/**
 *
  @author Kerem
 */
public final class Dashboard {
    
    static boolean control = true;  
    static Label label_name_of_the_player = new Label();
    static Label label_Name = new Label();
    static Label label_info_about_chart = new Label();   
    static Label label_age_of_the_dragon = new Label();
    static Label label_age_of_the_emotion = new Label();
    static Label label_total_number_of_steps = new Label();


    
    
    Integer left_label_player_name;
    Integer left_perc_pieChart;
    Integer left_age;
    Integer steps_perc;
    Integer steps_number;
    Integer dist_km;
    Integer sleep_monit_X;
    Integer sleep_monit_Y;
    Integer distance_overall;
    Integer calories_overall;
    String name_of_the_player;
 
    static Integer get_left_age;
    static Integer get_emotion;
    static Integer get_steps_overall;
    static Integer get_steps_number;
    static Integer get_dist_meter;
    static Integer get_calories_overall;
    static Integer get_calories_daily;
    static Label label_info = new Label();
    static Label label_info_about_chart_distance = new Label();
    static Label label_total_number_of_distance = new Label();



            
    
    public String get_left_label_player_name() {
        String name = "Reizz";
        return name;
    }
   

    public static void display(String title, String message){
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Acilan Pencerenin Basligi");
        window.setMinWidth(250);
        window.setMinHeight(350);

        final Label label_sync = new Label();
        label_sync.setText("The data was synchronized succesfully!");
        label_sync.setVisible(false);
        
        File image = new File("/Users/Kerem/Documents/Programlamalar/DragonFit/sweetDragon.png");
        Image imageStartPage = new Image(image.toURI().toString());
        
        //Displaying the image
        ImageView imageView = new ImageView();
        imageView.setImage(imageStartPage);
        imageView.setFitWidth(250);
        imageView.setFitHeight(250);
        VBox vBox_left_side = new VBox(10);
        vBox_left_side.getChildren().add(imageView);        

        

        label_Name.setText("DASHBOARD");
        
        //Here we need the pie
        
        //Here is the name of the player  ###LAter we need to get it from the previous entrence
        Label label_name_of_the_player = new Label();
        label_name_of_the_player.setText("Reizz");
        
         
        Label label_age_of_the_domination = new Label();
        label_age_of_the_domination.setText("for world domination");
             
//############# buraya ImageView gelmesi

        //Creating The steps region (1/4)
        Label label_title_steps = new Label();
        //label_title_steps.setText("Steps");
        
        ObservableList<PieChart.Data> pieChartSteps = FXCollections.observableArrayList(
                new PieChart.Data("Taken Steps",25),
                new PieChart.Data("Try Taken Steps",40)                
        );
        
        final PieChart chart = new PieChart(pieChartSteps);
        chart.setLabelLineLength(10);
        chart.setLegendSide(Side.TOP);
        chart.setMaxHeight(40);
        chart.setMaxWidth(40);
        
        
        //Creating the distance part(2/4)
        Label label_titel_distance = new Label();
        label_titel_distance.setText("Calories");
        
        
        //Creating the Calories part(3/4)
        ObservableList<PieChart.Data> pieChartCalories = FXCollections.observableArrayList(
                new PieChart.Data("Burned Calories", 75)
        );
        
        final PieChart chart_calories = new PieChart(pieChartCalories);
        chart_calories.setLabelLineLength(10);
        chart_calories.setLegendSide(Side.RIGHT);
        chart_calories.setMaxHeight(40);
        chart_calories.setMaxWidth(40);
       
       
        //Creating the Sleep part(4/4)
        Label label_sleep_mon = new Label("Sleep Monitoring");
        
        File image_chart = new File("/Users/Kerem/Documents/Programlamalar/DragonFit/chart.png");
        Image imageStartPage_chart = new Image(image_chart.toURI().toString());
        
        //Displaying the image
        ImageView imageView_chart = new ImageView(imageStartPage_chart);
        
        //imageView.setImage(imageStartPage_chart);
        imageView_chart.setFitWidth(700);
        imageView_chart.setFitHeight(100);
        
        Label label_info_about_sleep = new Label();
        label_info_about_sleep.setText("Sleep");
        
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Hours");
        yAxis.setLabel("Y Axis");
        
            //Creating the Chart
//        final LineChart <Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
//        lineChart.setTitle("Sleep Monitoring");
//            XYChart.Series series = new XYChart.Series();
//            series.setName("Sleeping Monitoring");
//            //populating the series with values
//            series.getData().add(new XYChart.Data(1, 34));
//            series.getData().add(new XYChart.Data(5, 50));
//            
        //Declaring the sync button
        Button button_sync = new Button("Sync");
        button_sync.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 if (control) {
                 label_sync.setVisible(true);
                 first_Day();                 
                 control = false;
                 }else{
                 label_sync.setVisible(false);    
                 second_Day();
                 control = true;
                 }
             }
         });
            
        
        HBox hBox_above = new HBox(10);
        hBox_above.getChildren().addAll(label_sync, button_sync);
        hBox_above.setAlignment(Pos.CENTER_RIGHT);
        hBox_above.setPadding(new Insets(15));
        
        //Add into those: LAbel, Pie, Name, Age, Emotion, "String" Domination
        
        //VBox vBox_left_side = new VBox(10);
        //vBox_left_side.getChildren().addAll(label_Name, imageView, label_age_of_the_dragon, label_age_of_the_emotion, label_name_of_the_player, label_age_of_the_domination);
        vBox_left_side.getChildren().addAll(label_Name, label_age_of_the_dragon, label_age_of_the_emotion, label_name_of_the_player, label_age_of_the_domination);
        vBox_left_side.setPadding(new Insets(40, 0, 40, 0));
        //vBox_left_side.ve
        vBox_left_side.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();
        //GridPane.setConstraints(label_title_steps, 0, 0);
//        GridPane.setConstraints(label_total_number_of_steps, 1, 1, 10, 1);
//        GridPane.setConstraints(label_info_about_chart, 2, 1, 10, 1);
        //### 1/4
        HBox chart_textes = new HBox(25);
        grid.getChildren().addAll(label_title_steps, chart);   
        GridPane.setConstraints(chart, 0, 1);        
        chart_textes.getChildren().addAll(label_info_about_chart, label_total_number_of_steps);
        chart_textes.setAlignment(Pos.CENTER);
        chart_textes.setPadding(new Insets(25));
        grid.getChildren().add(chart_textes);
        GridPane.setConstraints(chart_textes, 1, 1);
        
        //### 2/4
        HBox chart_textes_distance = new HBox(25);
        //hart_textes_distance.getChildren().addAll(label_titel_distance, label_info);
        chart_textes_distance.setPadding(new Insets(25));
        grid.getChildren().addAll(chart_textes_distance);
        GridPane.setConstraints(chart_textes_distance, 1, 2);
        GridPane.setConstraints(label_titel_distance, 0, 2);
        
        
        //### 3/4
        HBox chart_textes_distance_HBox = new HBox(25);
        grid.getChildren().addAll(label_titel_distance, chart_calories);   
        GridPane.setConstraints(chart_calories, 0, 3);        
        chart_textes_distance_HBox.getChildren().addAll(label_info_about_chart_distance, label_total_number_of_distance);
        chart_textes_distance_HBox.setAlignment(Pos.CENTER);
        chart_textes_distance_HBox.setPadding(new Insets(25));
        grid.getChildren().add(chart_textes_distance_HBox);
        GridPane.setConstraints(chart_textes_distance_HBox, 1, 3);
         
        //### 4/4
        HBox chart_textes_sleep = new HBox();
        chart_textes_sleep.getChildren().addAll(label_sleep_mon, label_title_steps);
        chart_textes_sleep.setPadding(new Insets(25));
        chart_textes_sleep.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(chart_textes_sleep, imageView_chart);
        GridPane.setConstraints(chart_textes_sleep, 0, 4);
        GridPane.setConstraints(imageView_chart, 1, 6);
        
        
        BorderPane borderPane_general = new BorderPane();
        borderPane_general.setTop(hBox_above);
        borderPane_general.setLeft(vBox_left_side);
        borderPane_general.setCenter(grid);
            
        Scene scene = new Scene(borderPane_general, 1500, 1500);
        scene.getStylesheets().add("healthgirlhackathon/newThema.css");
        window.setScene(scene);
        window.showAndWait();
        
//        readCSV();
    }
    
   public final static void first_Day(){
    label_info_about_chart.setText(25 + " of min\na day");  
    label_age_of_the_dragon.setText("Age: 32");        
    label_age_of_the_emotion.setText(51 + " % ready");    
    label_info_about_chart.setText("You Covered " + 5000);
    label_total_number_of_steps.setText( "You still need: " + 5000);
    label_info_about_chart_distance.setText("Calories ; You burned " + 1431);
    label_total_number_of_distance.setText( "In Total Today: " +1356 );
    label_info.setText( "Today:"+4151+  " steps");
       
    }
 
    public final static void second_Day(){
    label_info_about_chart.setText(25 + " of min\na day");  
    label_age_of_the_dragon.setText(27 + "");        
    label_age_of_the_emotion.setText(36 + " % ready");    
    label_info_about_chart.setText(6846 + " of min\na day");
    label_total_number_of_steps.setText( "In Total Today: " + 410260);
    label_info_about_chart_distance.setText("Calories ; You burned" + 1431);
    label_total_number_of_distance.setText( "In Total Today: " +1364 );
    label_info.setText( "Today:_"+5178+  " km");
    }
    
    
    
//    private static void readCSV() {
// 
//        String CsvFile = "/home/buddy/test/test.csv";
//        String FieldDelimiter = ",";
// 
//        BufferedReader br;
// 
//        try {
//            br = new BufferedReader(new FileReader(CsvFile));
// 
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(FieldDelimiter, -1);
// 
//                Record record = new Record(fields[0], fields[1], fields[2],
//                        fields[3], fields[4], fields[5]) {};
//                
//                dataList.add(record);
//                dataList.addAll(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
// 
//            }
// 
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(JavaFXCSVTableView.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(JavaFXCSVTableView.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
// 
//    }

    
}


 
//        public Integer get_left_age(Integer s) {
//           switch (s){
//                case 1:
//                    get_left_age = 25;
//                    break;
//                case 2:
//                     get_left_age = 27;
//                     break;
//                case 3:
//                     get_left_age = 30;
//                     break;
//                case 4:
//                     get_left_age = 30;
//                     break;
//                case 5:
//                     get_left_age = 32;
//                     break;
//                case 6:
//                     get_left_age = 33;
//                     break;
//            }
//           return get_left_age;
//        }
//
//        public Integer get_emotion(Integer s) {
//           switch (s){
//                case 1:
//                    get_emotion = 51;
//                    break;
//                case 2:
//                    get_emotion = 36;
//                    break;
//                case 3:
//                    get_emotion = 61;
//                    break;
//                case 4:
//                    get_emotion = 69;
//                    break;
//                case 5:
//                    get_emotion = 77;
//                    break;
//                case 6:
//                    get_emotion = 58;
//                    break;
//            }
//           return get_emotion;
//        }
// 
//        public Integer get_steps_overall(Integer s) {
//           switch (s){
//                case 1:
//                    get_steps_overall = 403414;
//                    break;
//                case 2:
//                    get_steps_overall = 410260;
//                    break;
//                case 3:
//                    get_steps_overall = 431482;
//                    break;
//                case 4:
//                    get_steps_overall = 447622;
//                    break;
//                case 5:
//                    get_steps_overall = 477090;
//                    break;
//                case 6:
//                    get_steps_overall = 498435;
//                    break;
//            }
//           return get_steps_overall;
//        }
//        
//        public Integer get_steps_number(Integer s) {
//           switch (s){
//                case 1:
//                    get_steps_number = 5584;
//                    break;
//                case 2:
//                    get_steps_number = 6846;
//                    break;
//                case 3:
//                    get_steps_number = 21222;
//                    break;
//                case 4:
//                    get_steps_number = 16140;
//                    break;
//                case 5:
//                    get_steps_number = 8482;
//                    break;
//                case 6:
//                    get_steps_number = 9964;
//                    break;
//            }
//           return get_steps_number;
//        }
// 
//        public Integer get_dist_meter(Integer s) {
//           switch (s){
//                case 1:
//                    get_dist_meter = 4151;
//                    break;
//                case 2:
//                    get_dist_meter = 5178;
//                    break;
//                case 3:
//                    get_dist_meter = 16693;
//                    break;
//                case 4:
//                    get_dist_meter = 6252;
//                    break;
//                case 5:
//                    get_dist_meter = 12610;
//                    break;
//                case 6:
//                    get_dist_meter = 10000;
//                    break;
//            }
//           return get_dist_meter;
//        }
//        
//        public Integer get_calories_overall(Integer s) {
//           switch (s){
//                case 1:
//                    get_calories_overall = 50270;
//                    break;
//                case 2:
//                    get_calories_overall = 51634;
//                    break;
//                case 3:
//                    get_calories_overall = 53056;
//                    break;
//                case 4:
//                    get_calories_overall = 54460;
//                    break;
//                case 5:
//                    get_calories_overall = 55884;
//                    break;
//                case 6:
//                    get_calories_overall = 57315;
//                    break;
//            }
//           return get_calories_overall;
//        }
//        
//       public Integer get_calories_daily(Integer s) {
//           switch (s){
//                case 1:
//                    get_calories_daily = 1356;
//                    break;
//                case 2:
//                    get_calories_daily = 1364;
//                    break;
//                case 3:
//                    get_calories_daily = 1422;
//                    break;
//                case 4:
//                    get_calories_daily = 1404;
//                    break;
//                case 5:
//                    get_calories_daily = 1424;
//                    break;
//                case 6:
//                    get_calories_daily = 1431;
//                    break;
//            }
//           return get_calories_daily;
//        }
//        
// Dashboard(int s){
//     s = 2;
// get_calories_daily = this.get_calories_daily(s);
// get_calories_overall = this.get_calories_overall(s);
// get_dist_meter = this.get_dist_meter(s);
// get_emotion = this.get_emotion(s);
// get_left_age = this.get_left_age(s);
// get_steps_number = this.get_steps_number(s);
// get_steps_overall = this.get_steps_overall(s);
// }
//    
 