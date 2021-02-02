/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AdminScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Button b1 = new Button("Add an Employee");
       Button b2 = new Button("Employee Details");
       Button b3 = new Button("Courier Booking");
       Button b4 = new Button("Courier Details");
       
        b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent event) 
           {
               Registration r = new Registration();
               try {
                   r.start(primaryStage);
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
               
              
           }
       });
        
         b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent event) 
           {
               EmployeeDetails r = new EmployeeDetails();
               try {
                   r.start(primaryStage);
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
               
              
           }
       });
         b3.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent event) 
           {
               Booking r = new Booking();
               try {
                   r.start(primaryStage);
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
               
              
           }
       });
         
         
         
      b4.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent event) 
           {
               CourierDetails r = new CourierDetails();
               try {
                   r.start(primaryStage);
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
               
              
           }
       });
        VBox v1 = new VBox(20,b1,b2,b3,b4);
        Scene s = new Scene(v1,300,300);
        primaryStage.setTitle("Screen");
        primaryStage.setScene(s);
        primaryStage.show();
    }
    
}
