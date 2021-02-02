/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author KRISH
 */
public class Adminlogin extends Application {
    
  
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage st) throws Exception {
       Label l1 = new Label("Name");
       TextField t1 = new TextField();
       HBox h1 = new HBox(50);
       h1.getChildren().addAll(l1,t1);
       Label l2 = new Label("Password");
       PasswordField t2 = new PasswordField();
       HBox h2 = new HBox(30);
       h2.getChildren().addAll(l2,t2);
       Button btn = new Button("Sign In");
       btn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent arg0) {
                String name = t1.getText();
                String password = t2.getText();
                Linking cnn = new Linking();
                cnn.fileopen();
                boolean ans = cnn.read(name,password);
                if(ans == true){
                    Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("Login Done");
                    a.showAndWait();
                    AdminScreen ad = new AdminScreen();
                   try {
                       ad.start(st);
                   } catch (Exception ex) {
                       Logger.getLogger(Adminlogin.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                else{
                    Alert al = new Alert(AlertType.ERROR);
                    al.setContentText("Login Error");
                    al.showAndWait();
                }
                
                cnn.close();
                
            }       
       });
       VBox v1 = new VBox(20,h1,h2,btn);
       Scene scene = new Scene (v1,350,200);
       st.setTitle("Admin Login");
       st.setScene(scene);
       st.show();
    }
    
}
