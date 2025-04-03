package tuan8_Luong;

public class ContractEmployee extends Employee {
	private double contractValue;
    private int vacationDays;

    public ContractEmployee(String name, String ssn, double contractValue, int vacationDays) {
        super(name, ssn);
        this.contractValue = contractValue;
        this.vacationDays = vacationDays;
    }

    @Override
    public double tinhLuongHangTuan() {
        return contractValue / 52;
    }

    @Override
    public int tinhSoNgayNghiPhep() {
        return vacationDays;
    }

    @Override
    public String toString() {
        return String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s",
                name, ssn, String.format("%.2f", tinhLuongHangTuan()), tinhSoNgayNghiPhep(),
                contractValue, "-", "-", "-", "-");
    }
}
