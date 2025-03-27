package tuan9_NhanVien;

import java.util.ArrayList;
import java.util.List;

public class SoftwareHouse {
    private String theName; // Tên công ty
    private List<Employee> list; // Danh sách nhân viên

    // Constructor
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

    // Hiển thị tất cả nhân viên
    public void displayAllStaff() {
    	System.out.println("Danh sách nhân viên của " + theName + ":");
        // In tiêu đề bảng
        System.out.printf("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|\n",
                "Payroll No", "Name", "Basic Salary", "Language", "Bonus", "Department", "Salary", "Type");
        System.out.println("|----------|--------------------|--------------------|--------------------|--------------------|--------------------|----------|----------|");

        // In danh sách nhân viên
        for (Employee emp : list) {
            System.out.println(emp.toString());
        }
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

    // Hiển thị danh sách lập trình viên
    public String displayListProgrammers() {
    	StringBuilder result = new StringBuilder("Danh sách lập trình viên:\n");
        // In tiêu đề bảng
        result.append(String.format("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|\n",
                "Payroll No", "Name", "Basic Salary", "Language", "Bonus", "Department", "Salary", "Type"));
        result.append("|----------|--------------------|--------------------|--------------------|--------------------|--------------------|----------|----------|\n");

        // In danh sách lập trình viên
        for (Employee emp : list) {
            if (emp instanceof Programmer) {
                result.append(emp.toString()).append("\n");
            }
        }
        return result.toString();
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