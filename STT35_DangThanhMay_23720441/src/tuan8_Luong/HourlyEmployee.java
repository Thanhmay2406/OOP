package tuan8_Luong;

public class HourlyEmployee extends Employee {
	private double hourlyWage;
    private int hoursWorked;
    private int overtimeHours;
    private double overtimeRate;
    private int vacationDays;

    public HourlyEmployee(String name, String ssn, double hourlyWage, int hoursWorked, int overtimeHours, double overtimeRate, int vacationDays) {
        super(name, ssn);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.vacationDays = vacationDays;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    @Override
    public double tinhLuongHangTuan() {
        double regularPay = hourlyWage * hoursWorked;
        double overtimePay = hourlyWage * overtimeRate * overtimeHours;
        return regularPay + overtimePay;
    }

    @Override
    public int tinhSoNgayNghiPhep() {
        return vacationDays;
    }

    @Override
    public String toString() {
        return String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s",
                name, ssn, String.format("%.2f", tinhLuongHangTuan()), tinhSoNgayNghiPhep(),
                "-", hourlyWage, hoursWorked, overtimeHours, overtimeRate);
    }
}