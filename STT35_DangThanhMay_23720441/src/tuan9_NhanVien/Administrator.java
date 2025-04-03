package tuan9_NhanVien;

public class Administrator extends Employee {
    private String theDepartment; // Phòng ban


    public Administrator(int payrollNumber, String name, double basicMonthlySalary, String department) {
        super(payrollNumber, name, basicMonthlySalary);
        this.theDepartment = department;
    }

    public String getDepartment() {
        return theDepartment;
    }

    @Override
    public double getMonthlySalary() {
        return theBasicMonthlySalary;
    }

    @Override
    public String toString() {
    	return String.format("|%-10d|%-20s|%-20.2f|%-20s|%-20s|%-20s|%-10.2f|%-10s|",
                thePayrollNumber, theName, theBasicMonthlySalary, "", "", theDepartment, getMonthlySalary(), "Admin");
    }
}