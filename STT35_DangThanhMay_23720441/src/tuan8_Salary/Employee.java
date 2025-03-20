package tuan8_Salary;

public abstract class Employee {
protected String firstName, lastName, SSN;
    
    public Employee(String fName, String lName, String ssn) {
        this.firstName = fName;
        this.lastName = lName;
        this.SSN = ssn;
    }
    
    public abstract double earnings();
    public abstract void display();
}
