package tuan9_NhanVien;

public class Programmer extends Employee {
    private String theLanguage; // Ngôn ngữ lập trình

    public Programmer(int payrollNumber, String name, double basicMonthlySalary, String language) {
        super(payrollNumber, name, basicMonthlySalary);
        this.theLanguage = language;
    }

    public String getLanguage() {
        return theLanguage;
    }

    @Override
    public double getMonthlySalary() {
        return theBasicMonthlySalary;
    }

    @Override
    public String toString() {
    	return String.format("|%-10d|%-20s|%-20.2f|%-20s|%-20s|%-20s|%-10.2f|%-10s|",
                thePayrollNumber, theName, theBasicMonthlySalary, theLanguage, "", "", getMonthlySalary(), "Programmer");
    }
}