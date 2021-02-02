package project;

import javafx.beans.property.SimpleStringProperty;

public class Couriers {

    private final SimpleStringProperty Parcal_no;
    private final SimpleStringProperty Date;
    private final SimpleStringProperty Reciever;
    private final SimpleStringProperty Delivery;
    private final SimpleStringProperty State;
    private final SimpleStringProperty City;
    private final SimpleStringProperty Item;
    private final SimpleStringProperty Price;
  
    Couriers(String Parcal_no, String Date, String Reciever, String Delivery, String State, String City,
            String Item, String Price) {
        this.Parcal_no = new SimpleStringProperty(Parcal_no);
        this.Date = new SimpleStringProperty(Date);
        this.Reciever = new SimpleStringProperty(Reciever);
        this.Delivery = new SimpleStringProperty(Delivery);
        this.State = new SimpleStringProperty(State);
        this.City = new SimpleStringProperty(City);
        this.Item = new SimpleStringProperty(Item);
        this.Price = new SimpleStringProperty(Price);
    }
    public String getParcal_no() {
        return Parcal_no.get();
    }

    public String getDate() {
        return Date.get();
    }

    public String getReciever() {
        return Reciever.get();
    }

    public String getDelivery() {
        return Delivery.get();
    }

    public String getState() {
        return State.get();
    }

    public String getCity() {
        return City.get();
    }

    public String getItem() {
        return Item.get();
    }

    public String getPrice() {
        return Price.get();
    }

  

}
