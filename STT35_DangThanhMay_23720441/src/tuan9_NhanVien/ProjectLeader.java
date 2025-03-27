package tuan9_NhanVien;

public class ProjectLeader extends Programmer {
    private double bonus; // Thưởng

    // Constructor
    public ProjectLeader(int payrollNumber, String name, double basicMonthlySalary, String language, double bonus) {
        super(payrollNumber, name, basicMonthlySalary, language);
        this.bonus = bonus;
    }

    // Getter
    public double getBonus() {
        return bonus;
    }

    // Triển khai phương thức getMonthlySalary
    @Override
    public double getMonthlySalary() {
        return theBasicMonthlySalary + bonus; // Lương của ProjectLeader = lương cơ bản + thưởng
    }

    // Phương thức toString
    @Override
    public String toString() {
    	return String.format("|%-10d|%-20s|%-20.2f|%-20s|%-20.2f|%-20s|%-10.2f|%-10s|",
                thePayrollNumber, theName, theBasicMonthlySalary, getLanguage(), bonus, "", getMonthlySalary(), "ProjLeader");
    }
}