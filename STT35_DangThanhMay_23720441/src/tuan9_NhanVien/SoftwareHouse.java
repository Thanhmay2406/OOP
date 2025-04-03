package tuan9_NhanVien;

import java.util.ArrayList;
import java.util.List;

public class SoftwareHouse {
    private String theName; // Tên công ty
    private List<Employee> list; // Danh sách nhân viên

    public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

    public SoftwareHouse(String name) {
        this.theName = name;
        this.list = new ArrayList<>();
    }

    // Thêm nhân viên
    public boolean addEmployee(Employee employee) {
        for (Employee emp : list) {
            if (emp.getPayrollNumber() == employee.getPayrollNumber()) {
                return false; // Trùng mã số, không thêm được
            }
        }
        list.add(employee);
        return true;
    }

    // Lấy tổng lương hàng tháng
    public double getMonthlySalaryBill() {
        double total = 0;
        for (Employee emp : list) {
            total += emp.getMonthlySalary();
        }
        return total;
    }

    // Sắp xếp nhân viên theo tên
    public void sortAllStaffByName() {
        list.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
    }


    // Cập nhật phòng ban cho Administrator
    public boolean updateDepartmentForAdmin(int payrollNumber, String newDepartment) {
        for (Employee emp : list) {
            if (emp instanceof Administrator && emp.getPayrollNumber() == payrollNumber) {
                ((Administrator) emp).getDepartment();
                return true;
            }
        }
        return false;
    }
}