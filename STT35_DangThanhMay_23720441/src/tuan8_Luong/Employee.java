package tuan8_Luong;

import java.util.Objects;

public abstract class Employee {
	protected String name;
	protected String ssn;
	public Employee(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public abstract double tinhLuongHangTuan();
	public abstract int tinhSoNgayNghiPhep();
	@Override
	public int hashCode() {
		return Objects.hash(ssn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(ssn, other.ssn);
	}
	@Override
    public String toString() {
        return String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s",
                name, ssn, tinhLuongHangTuan(), tinhSoNgayNghiPhep(), "-", "-", "-", "-", "-");
    }
}