
package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class EmployeeDetails extends Application{
    public static void main(String[] args) {
       launch(args);
    }
    
    
     public void start(Stage ps) throws Exception {
         TableView<Employees> t = new TableView<Employees>();
          
          Scene scene = new Scene(new Group());
        ps.setTitle("Employees Details");
        ps.setWidth(800);
        ps.setHeight(500);
 
        final Label label = new Label("Employee Information");
        label.setFont(new Font("Arial", 20));
 
        t.setEditable(true);
 
        TableColumn IdCol = new TableColumn("Emp ID");
        IdCol.setMinWidth(50);
        IdCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Emp_ID"));
 
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Name"));
 
        TableColumn PasCol = new TableColumn("Password");
        PasCol.setMinWidth(60);
        PasCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Password"));
           
        TableColumn DOBCol = new TableColumn("DOB");
        DOBCol.setMinWidth(60);
        DOBCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("DOB"));
        
        TableColumn GenderCol = new TableColumn("Gender");
        GenderCol.setMinWidth(60);
        GenderCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("gender"));
        
        TableColumn EmailCol = new TableColumn("Email");
        EmailCol.setMinWidth(150);
        EmailCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Email"));
        
        TableColumn QuaCol = new TableColumn("Qualification");
        QuaCol.setMinWidth(150);
        QuaCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Qualification"));
        
        TableColumn Ph_noCol = new TableColumn("Phone No");
        Ph_noCol.setMinWidth(100);
        Ph_noCol.setCellValueFactory(
                new PropertyValueFactory<Employees, String>("Phone_No"));
        
        
        t.setItems(getdata());
        t.getColumns().addAll(IdCol, NameCol,PasCol,DOBCol,GenderCol,EmailCol,QuaCol,Ph_noCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, t);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        ps.setScene(scene);
        ps.show();
    
         

         
     }
     
     private ObservableList<Employees> getdata() throws IOException,FileNotFoundException 
     {
         Linking cnn = new Linking();
         ObservableList<Employees> tabledata = FXCollections.observableArrayList();
         String data[][] = cnn.readfullrecord();
         for(int i = 0; i < cnn.linecount ;i++)
         {
             tabledata.add(new Employees(data[i][0],data[i][1],data[i][2],data[i][3]
                     ,data[i][4],data[i][5],data[i][6],data[i][7]));  
         }
         return tabledata;
                 
     }

  
}
