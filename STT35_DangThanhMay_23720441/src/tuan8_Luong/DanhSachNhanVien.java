package tuan8_Luong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachNhanVien {
	private List<Employee> employees;

    public DanhSachNhanVien(int capacity) {
        employees = new ArrayList<>(capacity);
    }

    public void addEmployee(Employee emp) throws Exception {
        if (employees.contains(emp)) {
            throw new Exception("Trùng SSN nhân viên!");
        }
        employees.add(emp);
    }

    public Employee findEmployee(String ssn) {
        for (Employee emp : employees) {
            if (emp.getSsn().equals(ssn)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getHighSalaryEmployees() {
        List<Employee> highSalaryList = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.tinhLuongHangTuan() > 1000) {
                highSalaryList.add(emp);
            }
        }
        return highSalaryList;
    }

    public void sortByName() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
    }

    public void sortByWeeklySalary() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.tinhLuongHangTuan(), e1.tinhLuongHangTuan());
            }
        });
    }

    public void sortByVacationDays() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.tinhSoNgayNghiPhep(), e2.tinhSoNgayNghiPhep());
            }
        });
    }

    public void updateSalariedEmployee(String ssn, double newAnnualSalary) throws Exception {
        Employee emp = findEmployee(ssn);
        if (emp == null) {
            throw new Exception("Không tìm thấy nhân viên!");
        }
        if (!(emp instanceof SalariedEmployee)) {
            throw new Exception("Nhân viên không phải là nhân viên hưởng lương cố định!");
        }
        ((SalariedEmployee) emp).setLuongHangNam(newAnnualSalary);
    }

    public void removeEmployee(String ssn) throws Exception {
        Employee emp = findEmployee(ssn);
        if (emp == null) {
            throw new Exception("Không tìm thấy nhân viên!");
        }
        employees.remove(emp);
    }

    public int getTotalEmployees() {
        return employees.size();
    }

    public List<HourlyEmployee> getOvertimeHourlyEmployees() {
        List<HourlyEmployee> overtimeList = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmp = (HourlyEmployee) emp;
                if (hourlyEmp.getOvertimeHours() > 0) {
                    overtimeList.add(hourlyEmp);
                }
            }
        }
        return overtimeList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                "Tên", "SSN", "Lương tuần", "Ngày nghỉ", "Lương năm", "Lương giờ", "Giờ làm", "Giờ OT", "Hệ số OT"));
        for (Employee emp : employees) {
            sb.append(emp.toString()).append("\n");
        }
        return sb.toString();
    }
}