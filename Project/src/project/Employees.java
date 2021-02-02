package project;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;

public class Employees {
    
    private final SimpleStringProperty Emp_ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Password;
    private final SimpleStringProperty DOB;
    private final SimpleStringProperty Gender;
    private final SimpleStringProperty Email;
    private final SimpleStringProperty Phone_No;
    private final SimpleStringProperty Qualification;
   
    
    
    
    Employees(String Id,String Name,String Psword,String DOB,String Gender,String Email,
            String Qualification,String Ph_No)
    {
        this.Name = new SimpleStringProperty (Name);
        this.Emp_ID = new SimpleStringProperty (Id);
        this.Password = new SimpleStringProperty(Psword);
        this.DOB = new SimpleStringProperty(DOB);
        this.Gender = new SimpleStringProperty(Gender);
        this.Email = new SimpleStringProperty(Email);
        this.Qualification = new SimpleStringProperty(Qualification);
        this.Phone_No= new SimpleStringProperty(Ph_No);
    }
   
    
    public String getEmp_ID() {
        return Emp_ID.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getPassword() {
        return Password.get();
    }

    public String getDOB() {
        return DOB.get();
    }

    public String getGender() {
        return Gender.get();
    }

    public String getEmail() {
        return Email.get();
    }

    public String getQualification() {
        return Qualification.get();
    }

    public String getPhone_No() {
        return Phone_No.get();
    }
    
    
   
    
}
