/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Booking extends Application{
     public static void main(String[] args) {
       launch(args);
    }
      public void start(Stage primaryStage) throws Exception {
        Label l1 = new Label("Parcel No");
        TextField t1 = new TextField();
        Label l1_1 = new Label("Date");
        DatePicker t1_1 = new DatePicker();
        Label l1_2 = new Label("Time");
        TextField t1_2 = new TextField();
        
        GridPane g = new GridPane();
        
        g.addRow(0, l1,t1,l1_1,t1_1,l1_2,t1_2);
        
        
        Label l2 = new Label("Delivery");
        ComboBox<String> t2 = new ComboBox<String>();
        t2.getItems().addAll("Standard","Overnight","Rush ON");
        t2.setPromptText("Select");
        Label l2_1 = new Label("State");
        ComboBox<String> t2_1 = new ComboBox<String>();
        t2_1.getItems().addAll("Sindh","Punjab","Balochistan");
        t2_1.setPromptText("Select");
        Label l2_2 = new Label("City");
        ComboBox<String> t2_2 = new ComboBox<String>();
        t2_2.getItems().addAll("Karachi","Lahore","Islamabad");
        t2_2.setPromptText("Select");
        
        
        g.addRow(2,l2,t2,l2_1,t2_1,l2_2,t2_2);
        
        
        Label l3_1 = new Label("From Address");
        Label l3_2 = new Label("To Address");
        g.add(l3_1, 1, 4);
        g.add(l3_2, 4, 4);
        
        Label l4_1 = new Label("Name");
        TextField t4_1 = new TextField();
        Label l4_2 = new Label("Name");
        TextField t4_2 = new TextField();
        g.add(l4_1, 0, 6);
        g.add(t4_1, 1, 6);

        g.add(l4_2, 4, 6);
        g.add(t4_2, 5, 6);
        
        Label l5_1 = new Label("Source");
        TextField t5_1 = new TextField();
        Label l5_2 = new Label("Destination");
        TextField t5_2 = new TextField();
        g.add(l5_1, 0, 7);
        g.add(t5_1,1,7);
        g.add(l5_2, 4, 7);
        g.add(t5_2,5,7);

        Label l6_1 = new Label("Phone No.");
        TextField t6_1 = new TextField();
        Label l6_2 = new Label("Phone No.");
        TextField t6_2 = new TextField();
        g.add(l6_1, 0, 8);
        g.add(t6_1,1,8);
        g.add(l6_2,4, 8);
        g.add(t6_2,5,8);
        
        
        Label l7_1 = new Label("Item");
        TextField t7_1 = new TextField();
        Label l7_2 = new Label("Price");
        TextField t7_2 = new TextField();
        g.add(l7_1, 0, 9);
        g.add(t7_1,1,9);
        g.add(l7_2, 4, 9);
        g.add(t7_2,5,9);
        
        Button b1 = new Button("Submit Form");
        g.add(b1, 3, 13);
      

        
        g.setVgap(10);
        g.setHgap(5);
         b1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                String details = "";
                String g = "";
                String l = "";

                
                details += t1.getText() + ",";
                details += t1_1.getValue() + ",";
                details += t1_2.getText() + ",";
                
                details += t2.getValue() + ",";
                details += t2_1.getValue() + ",";
                details += t2_2.getValue() + ",";
                
                
                details += t4_1.getText() + ",";
                details += t4_2.getText() + ",";
                
                details += t5_1.getText() + ",";
                details += t5_2.getText() + ",";
                
                details += t6_1.getText() + ",";
                details += t6_2.getText() + ",";
                
                details += t7_1.getText() + ",";
                details += t7_2.getText() ;
                
                
                
               
                Linking cnn = new Linking();
                try {
                    cnn.writetofile1(details);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Courier Booking Done");
                    a.showAndWait();
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
            
        });
        
  
        Scene s1 = new Scene(g,700,500);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Booking");
        primaryStage.show();

      
}

    
}
