package tuan9_NhanVien;

public abstract class Employee {
    protected int thePayrollNumber; // Mã số nhân viên
    protected String theName;       // Tên nhân viên
    protected double theBasicMonthlySalary; // Lương cơ bản hàng tháng

    public Employee(int payrollNumber, String name, double basicMonthlySalary) {
        this.thePayrollNumber = payrollNumber;
        this.theName = name;
        this.theBasicMonthlySalary = basicMonthlySalary;
    }

    public int getPayrollNumber() {
        return thePayrollNumber;
    }

    public String getName() {
        return theName;
    }

    public double getBasicMonthlySalary() {
        return theBasicMonthlySalary;
    }

    @Override
    public String toString() {
        return "Payroll Number: " + thePayrollNumber + ", Name: " + theName + 
               ", Basic Monthly Salary: " + theBasicMonthlySalary;
    }

    public abstract double getMonthlySalary();
}