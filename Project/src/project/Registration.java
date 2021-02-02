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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Registration extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
     public void start(Stage primaryStage) throws Exception {
        Label l1 = new Label("Emp ID");
        TextField t1 = new TextField();
        GridPane g = new GridPane();
        
        g.add(l1, 0, 0);
        g.add(t1,1,0);
        
        Label l2 = new Label("Name");
        TextField t2 = new TextField();
        g.add(l2, 0, 1);
        g.add(t2,1,1);
        
        Label l3_1 = new Label("Password");
        PasswordField t3_1 = new PasswordField();
        g.add(l3_1, 0, 2);
        g.add(t3_1, 1, 2);
        
        Label l3 = new Label("Date of Birth");
        DatePicker t3 = new DatePicker();
        g.add(l3,0,3);
        g.add(t3,1,3);
        
        Label l4 = new Label("Gender");
        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton("Male");
        RadioButton r2 = new RadioButton("Female");
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        g.add(l4, 0, 4);
        g.add(r1,1,4);
        g.add(r2,2,4);
        
        Label l5 = new Label("Email ID");
        TextField t5 = new TextField();
        g.add(l5, 0,5);
        g.add(t5,1,5);
       
        
        Label l6 = new Label("Qualification");
        ComboBox<String> t6 = new ComboBox<String>();
        t6.getItems().addAll("Intermediate","Graduation","Masters");
        t6.setPromptText("Select");
        g.add(l6,0,6);
        g.add(t6, 1,6);
        
        Label l6_1 = new Label("Phone Number");
        TextField t6_1 = new TextField();
        g.add(l6_1,0,7);
        g.add(t6_1, 1,7);
        Button b1 = new Button("Submit Form");
        g.add(b1, 1, 9);
        
        g.setVgap(10);
        g.setHgap(5);
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                String details = "";
                String g = "";
                String l = "";

                
                details += t1.getText() + ",";
                
               
                
                details += t2.getText() + ",";
                
                details += t3_1.getText() + ",";
                
                details += t3.getValue() + ",";
                
                 if(r1.isSelected()){
                    g = "Male";
                }
                else if(r2.isSelected()){
                    g = "Female";
                }
                else{
                    g = "Null";
                }
                details += g + ","; 
                
                details += t5.getText() +",";
                
                details += t6.getValue() +",";
                
                details += t6_1.getText() ;
  
                Linking cnn = new Linking();
                try {
                    cnn.writetofile2(details);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Registration Completed");
                    a.showAndWait();
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
            
        });
  
        Scene s1 = new Scene(g,500,400);
        primaryStage.setScene(s1);
        primaryStage.setTitle("Employee Registration");
        primaryStage.show();

      
}
}
