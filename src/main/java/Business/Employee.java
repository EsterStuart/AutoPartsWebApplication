package Business;

import java.sql.*;

public class Employee {
    private String employeeID;

    // Constructor
    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    // Get Method
    public String getEmployeeID() {
        return employeeID;
    }

    // Set Method
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    // Select from Database
    public void SelectDB(String employeeID) {
        System.out.println("Selecting data from the database for employee ID: " + employeeID);
    }

    // Insert to Database
    public void InsertDB() {
        System.out.println("Inserting data into the database for employee ID: " + employeeID);
    }

    // Update Database
    public void UpdateDB() {
        System.out.println("Updating data in the database for employee ID: " + employeeID);
    }

    // Delete from Database
    public void DeleteDB() {
        System.out.println("Deleting data from the database for employee ID: " + employeeID);
    }
}
