package tuan9_NhanVien;

public class Programmer extends Employee {
    private String theLanguage; // Ngôn ngữ lập trình

    // Constructor
    public Programmer(int payrollNumber, String name, double basicMonthlySalary, String language) {
        super(payrollNumber, name, basicMonthlySalary);
        this.theLanguage = language;
    }

    // Getter
    public String getLanguage() {
        return theLanguage;
    }

    // Triển khai phương thức getMonthlySalary
    @Override
    public double getMonthlySalary() {
        return theBasicMonthlySalary; // Lương của Programmer bằng lương cơ bản
    }

    // Phương thức toString
    @Override
    public String toString() {
    	return String.format("|%-10d|%-20s|%-20.2f|%-20s|%-20s|%-20s|%-10.2f|%-10s|",
                thePayrollNumber, theName, theBasicMonthlySalary, theLanguage, "", "", getMonthlySalary(), "Programmer");
    }
}