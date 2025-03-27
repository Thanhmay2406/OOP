package tuan9_NhanVien;

public abstract class Employee {
    protected int thePayrollNumber; // Mã số nhân viên
    protected String theName;       // Tên nhân viên
    protected double theBasicMonthlySalary; // Lương cơ bản hàng tháng

    // Constructor
    public Employee(int payrollNumber, String name, double basicMonthlySalary) {
        this.thePayrollNumber = payrollNumber;
        this.theName = name;
        this.theBasicMonthlySalary = basicMonthlySalary;
    }

    // Getter và Setter
    public int getPayrollNumber() {
        return thePayrollNumber;
    }

    public String getName() {
        return theName;
    }

    public double getBasicMonthlySalary() {
        return theBasicMonthlySalary;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Payroll Number: " + thePayrollNumber + ", Name: " + theName + 
               ", Basic Monthly Salary: " + theBasicMonthlySalary;
    }

    // Phương thức trừu tượng getMonthlySalary
    public abstract double getMonthlySalary();
}