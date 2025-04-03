package tuan8_Luong;

import java.util.List;
import java.util.Scanner;

public class TestNhanVien {
	public static Scanner sc = new Scanner(System.in);

    public static SalariedEmployee nhapSalariedEmployee() {
        System.out.printf("Nhập tên: ");
        String name = sc.next();
        System.out.printf("Nhập SSN: ");
        String ssn = sc.next();
        System.out.printf("Nhập lương hàng năm: ");
        double annualSalary = sc.nextDouble();
        System.out.printf("Nhập số tuần làm việc trong năm: ");
        int weeksWorkedPerYear = sc.nextInt();
        System.out.printf("Nhập số tuần nghỉ phép: ");
        int vacationWeeks = sc.nextInt();
        return new SalariedEmployee(name, ssn, annualSalary, weeksWorkedPerYear, vacationWeeks);
    }

    public static HourlyEmployee nhapHourlyEmployee() {
        System.out.printf("Nhập tên: ");
        String name = sc.next();
        System.out.printf("Nhập SSN: ");
        String ssn = sc.next();
        System.out.printf("Nhập lương giờ: ");
        double hourlyWage = sc.nextDouble();
        System.out.printf("Nhập số giờ làm việc: ");
        int hoursWorked = sc.nextInt();
        System.out.printf("Nhập số giờ làm thêm: ");
        int overtimeHours = sc.nextInt();
        System.out.printf("Nhập hệ số làm thêm: ");
        double overtimeRate = sc.nextDouble();
        System.out.printf("Nhập số ngày nghỉ phép: ");
        int vacationDays = sc.nextInt();
        return new HourlyEmployee(name, ssn, hourlyWage, hoursWorked, overtimeHours, overtimeRate, vacationDays);
    }

    public static ContractEmployee nhapContractEmployee() {
        System.out.printf("Nhập tên: ");
        String name = sc.next();
        System.out.printf("Nhập SSN: ");
        String ssn = sc.next();
        System.out.printf("Nhập giá trị hợp đồng: ");
        double contractValue = sc.nextDouble();
        System.out.printf("Nhập số ngày nghỉ phép: ");
        int vacationDays = sc.nextInt();
        return new ContractEmployee(name, ssn, contractValue, vacationDays);
    }

    private static void themNhanVien(DanhSachNhanVien ds) throws Exception {
        int choice;
        do {
            System.out.println("Chọn loại nhân viên muốn thêm:");
            System.out.println("1. Nhân viên hưởng lương cố định");
            System.out.println("2. Nhân viên làm việc theo giờ");
            System.out.println("3. Nhân viên hợp đồng");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 3);

        if (choice == 1) {
            SalariedEmployee emp = nhapSalariedEmployee();
            ds.addEmployee(emp);
        } else if (choice == 2) {
            HourlyEmployee emp = nhapHourlyEmployee();
            ds.addEmployee(emp);
        } else {
            ContractEmployee emp = nhapContractEmployee();
            ds.addEmployee(emp);
        }
        System.out.println("Thêm nhân viên thành công!");
    }

    private static void timKiemNhanVien(DanhSachNhanVien ds) {
        System.out.printf("Nhập SSN nhân viên cần tìm: ");
        String ssn = sc.next();
        Employee emp = ds.findEmployee(ssn);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.err.println("Không tìm thấy nhân viên!");
        }
    }

    private static void layThongTinDanhSach(DanhSachNhanVien ds) {
        System.out.println(ds);
    }

    private static void layNhanVienLuongCao(DanhSachNhanVien ds) {
        List<Employee> highSalaryList = ds.getHighSalaryEmployees();
        if (highSalaryList.isEmpty()) {
            System.out.println("Không có nhân viên nào có lương tuần trên 1000 USD!");
        } else {
            System.out.println("Danh sách nhân viên có lương tuần trên 1000 USD:");
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                    "Tên", "SSN", "Lương tuần", "Ngày nghỉ", "Lương năm", "Lương giờ", "Giờ làm", "Giờ OT", "Hệ số OT");
            for (Employee emp : highSalaryList) {
                System.out.println(emp);
            }
        }
    }

    private static void sapXepTheoTen(DanhSachNhanVien ds) {
        ds.sortByName();
        System.out.println("Đã sắp xếp tăng dần theo tên!");
        layThongTinDanhSach(ds);
    }

    private static void sapXepTheoLuongTuan(DanhSachNhanVien ds) {
        ds.sortByWeeklySalary();
        System.out.println("Đã sắp xếp giảm dần theo lương tuần!");
        layThongTinDanhSach(ds);
    }

    private static void sapXepTheoNgayNghi(DanhSachNhanVien ds) {
        ds.sortByVacationDays();
        System.out.println("Đã sắp xếp tăng dần theo số ngày nghỉ phép!");
        layThongTinDanhSach(ds);
    }

    private static void capNhatLuongNam(DanhSachNhanVien ds) throws Exception {
        System.out.printf("Nhập SSN nhân viên cần cập nhật lương hàng năm: ");
        String ssn = sc.next();
        System.out.printf("Nhập lương hàng năm mới: ");
        double newAnnualSalary = sc.nextDouble();
        try {
            ds.updateSalariedEmployee(ssn, newAnnualSalary);
            System.out.println("Cập nhật lương hàng năm thành công!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void xoaNhanVien(DanhSachNhanVien ds) throws Exception {
        System.out.printf("Nhập SSN nhân viên cần xóa: ");
        String ssn = sc.next();
        try {
            ds.removeEmployee(ssn);
            System.out.println("Xóa nhân viên thành công!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void tinhTongSoNhanVien(DanhSachNhanVien ds) {
        System.out.println("Tổng số nhân viên: " + ds.getTotalEmployees());
    }

    private static void layNhanVienCoLamThem(DanhSachNhanVien ds) {
        List<HourlyEmployee> overtimeList = ds.getOvertimeHourlyEmployees();
        if (overtimeList.isEmpty()) {
            System.out.println("Không có nhân viên làm việc theo giờ nào có giờ làm thêm!");
        } else {
            System.out.println("Danh sách nhân viên làm việc theo giờ có giờ làm thêm:");
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n",
                    "Tên", "SSN", "Lương tuần", "Ngày nghỉ", "Lương năm", "Lương giờ", "Giờ làm", "Giờ OT", "Hệ số OT");
            for (HourlyEmployee emp : overtimeList) {
                System.out.println(emp);
            }
        }
    }

    private static void thoatChuongTrinh() {
        System.out.println("Thoát chương trình!");
        sc.close();
    }
    
    private static void menu() {
    	System.out.println("1. Thêm nhân viên vào danh sách");
        System.out.println("2. Tìm kiếm nhân viên theo SSN");
        System.out.println("3. Hiển thị toàn bộ danh sách nhân viên");
        System.out.println("4. Lấy danh sách nhân viên có lương tuần trên 1000 USD");
        System.out.println("5. Sắp xếp tăng dần theo tên");
        System.out.println("6. Sắp xếp giảm dần theo lương tuần");
        System.out.println("7. Sắp xếp tăng dần theo số ngày nghỉ phép");
        System.out.println("8. Cập nhật lương hàng năm cho nhân viên hưởng lương cố định");
        System.out.println("9. Xóa một nhân viên theo SSN");
        System.out.println("10. Tính tổng số nhân viên");
        System.out.println("11. Lấy danh sách nhân viên làm việc theo giờ có giờ làm thêm");
        System.out.println("0. Thoát");
        System.out.printf("Nhập lựa chọn của bạn: ");
    }

    public static void main(String[] args) throws Exception {
        DanhSachNhanVien ds = new DanhSachNhanVien(10);
        int choice;

        do {
            menu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    themNhanVien(ds);
                    break;
                case 2:
                    timKiemNhanVien(ds);
                    break;
                case 3:
                    layThongTinDanhSach(ds);
                    break;
                case 4:
                    layNhanVienLuongCao(ds);
                    break;
                case 5:
                    sapXepTheoTen(ds);
                    break;
                case 6:
                    sapXepTheoLuongTuan(ds);
                    break;
                case 7:
                    sapXepTheoNgayNghi(ds);
                    break;
                case 8:
                    capNhatLuongNam(ds);
                    break;
                case 9:
                    xoaNhanVien(ds);
                    break;
                case 10:
                    tinhTongSoNhanVien(ds);
                    break;
                case 11:
                    layNhanVienCoLamThem(ds);
                    break;
                case 0:
                    thoatChuongTrinh();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}
