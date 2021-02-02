package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CourierDetails extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage ps) throws Exception {

        TableView<Couriers> t = new TableView<Couriers>();

        Scene scene = new Scene(new Group());
        ps.setTitle("Courier Details");
        ps.setWidth(800);
        ps.setHeight(500);

        final Label label = new Label("Show Booking");
        label.setFont(new Font("Arial", 20));

        t.setEditable(true);

        TableColumn ParcalCol = new TableColumn("Parcal_no");
        ParcalCol.setMinWidth(50);
        ParcalCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Parcal_no"));

        TableColumn DateCol = new TableColumn("Date");
        DateCol.setMinWidth(100);
        DateCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Date"));

        TableColumn RecieverCol = new TableColumn("Reciever");
        RecieverCol.setMinWidth(60);
        RecieverCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Reciever"));

        TableColumn DeliveryCol = new TableColumn("Delivery");
        DeliveryCol.setMinWidth(60);
        DeliveryCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Delivery"));

        TableColumn StateCol = new TableColumn("State");
        StateCol.setMinWidth(60);
        StateCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("State"));

        TableColumn CityCol = new TableColumn("City");
        CityCol.setMinWidth(150);
        CityCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("City"));

        TableColumn ItemCol = new TableColumn("Item");
        ItemCol.setMinWidth(150);
        ItemCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Item"));

        TableColumn PriceCol = new TableColumn("Price");
        PriceCol.setMinWidth(100);
        PriceCol.setCellValueFactory(
                new PropertyValueFactory<Couriers, String>("Price"));

        t.setItems(getdata());
        t.getColumns().addAll(ParcalCol, DateCol, RecieverCol, DeliveryCol,
                StateCol, CityCol, ItemCol, PriceCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, t);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        ps.setScene(scene);
        ps.show();

    }

    private ObservableList<Couriers> getdata() throws IOException, FileNotFoundException {
        Linking cnn = new Linking();
        ObservableList<Couriers> tabledata = FXCollections.observableArrayList();
        String data[][] = cnn.readfullrecord1();
        for (int i = 0; i < cnn.linecount1; i++) {
            tabledata.add(new Couriers(data[i][0], data[i][1], data[i][6], data[i][3], data[i][4],
                    data[i][5],data[i][12], data[i][13]));
        }
        return tabledata;

    }

}
