package tuan9_NhanVien;

import java.util.Scanner;

public class test {
	private static Scanner scanner = new Scanner(System.in);
    private static SoftwareHouse company = new SoftwareHouse("001");

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    displayAllStaff();
                    break;
                case 3:
                    displayMonthlySalaryBill();
                    break;
                case 4:
                    sortStaffByName();
                    break;
                case 5:
                    displayListProgrammers();
                    break;
                case 6:
                    updateDepartmentForAdmin();
                    break;
                case 7:
                    importSampleData();
                    break;
                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }
    
    private static void menu() {
    	System.out.println("\n=== MENU QUẢN LÝ CÔNG TY PHẦN MỀM ===");
        System.out.println("1. Nhập mềm");
        System.out.println("2. Hiển thị danh sách tất cả nhân viên");
        System.out.println("3. Hiển thị tổng lương hàng tháng");
        System.out.println("4. Sắp xếp nhân viên theo tên");
        System.out.println("5. Hiển thị danh sách lập trình viên");
        System.out.println("6. Cập nhật phòng ban cho Administrator");
        System.out.println("7. Nhập cứng");
        System.out.println("0. Thoát chương trình");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    // Hàm nhập thông tin nhân viên từ người dùng
    private static Employee inputEmployeeInfo() {
        System.out.println("\nChọn loại nhân viên để nhập thông tin:");
        System.out.println("1. Programmer");
        System.out.println("2. Project Leader");
        System.out.println("3. Administrator");
        System.out.print("Nhập lựa chọn: ");
        int employeeType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập mã số nhân viên: ");
        int payrollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập lương cơ bản hàng tháng: ");
        double basicSalary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = null;
        switch (employeeType) {
            case 1: // Programmer
                System.out.print("Nhập ngôn ngữ lập trình: ");
                String language = scanner.nextLine();
                employee = new Programmer(payrollNumber, name, basicSalary, language);
                break;

            case 2: // Project Leader
                System.out.print("Nhập ngôn ngữ lập trình: ");
                String leaderLanguage = scanner.nextLine();
                System.out.print("Nhập tiền thưởng: ");
                double bonus = scanner.nextDouble();
                employee = new ProjectLeader(payrollNumber, name, basicSalary, leaderLanguage, bonus);
                break;

            case 3: // Administrator
                System.out.print("Nhập phòng ban: ");
                String department = scanner.nextLine();
                employee = new Administrator(payrollNumber, name, basicSalary, department);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return null;
        }

        return employee;
    }

    // Hàm 1: Thêm nhân viên mới (sử dụng inputEmployeeInfo)
    private static void addNewEmployee() {
        Employee employee = inputEmployeeInfo();
        if (employee == null) {
            System.out.println("Không thể thêm nhân viên do nhập thông tin không hợp lệ!");
            return;
        }

        if (company.addEmployee(employee)) {
            System.out.println("Thêm nhân viên thành công!");
        } else {
            System.out.println("Thêm nhân viên thất bại! Mã số nhân viên đã tồn tại.");
        }
    }

    private static void displayAllStaff() {
    	System.out.println("Danh sách nhân viên của " + company.getTheName() + ":");
        System.out.printf("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|\n",
                "Payroll No", "Name", "Basic Salary", "Language", "Bonus", "Department", "Salary", "Type");
        System.out.println("|----------|--------------------|--------------------|--------------------|--------------------|--------------------|----------|----------|");

        for (Employee emp : company.getList()) {
            System.out.println(emp.toString());
        }
    }

    // Hàm 3: Hiển thị tổng lương hàng tháng
    private static void displayMonthlySalaryBill() {
        System.out.println("Tổng lương hàng tháng: " + company.getMonthlySalaryBill());
    }

    // Hàm 4: Sắp xếp nhân viên theo tên
    private static void sortStaffByName() {
        company.sortAllStaffByName();
        System.out.println("Đã sắp xếp nhân viên theo tên!");
        displayAllStaff();
    }

    // Hàm 5: Hiển thị danh sách lập trình viên
    private static void displayListProgrammers() {
    	StringBuilder result = new StringBuilder("Danh sách lập trình viên:\n");
        // In tiêu đề bảng
        result.append(String.format("|%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|%-10s|%-10s|\n",
                "Payroll No", "Name", "Basic Salary", "Language", "Bonus", "Department", "Salary", "Type"));
        result.append("|----------|--------------------|--------------------|--------------------|--------------------|--------------------|----------|----------|\n");

        for (Employee emp : company.getList()) {
            if (emp instanceof Programmer) {
                result.append(emp.toString()).append("\n");
            }
        }
        System.out.println(result.toString());
    }

    // Hàm 6: Cập nhật phòng ban cho Administrator
    private static void updateDepartmentForAdmin() {
        System.out.print("Nhập mã số nhân viên (Administrator) cần cập nhật: ");
        int adminPayrollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập phòng ban mới: ");
        String newDepartment = scanner.nextLine();

        if (company.updateDepartmentForAdmin(adminPayrollNumber, newDepartment)) {
            System.out.println("Cập nhật phòng ban thành công!");
        } else {
            System.out.println("Cập nhật thất bại! Không tìm thấy Administrator với mã số này.");
        }
    }

    // Hàm 7: Nhập dữ liệu mẫu (nhập mềm)
    private static void importSampleData() {
        Employee p1 = new Programmer(1, "Nguyen Van A", 5000, "Java");
        Employee p2 = new Programmer(2, "Tran Thi B", 5500, "Python");
        Employee pl1 = new ProjectLeader(3, "Le Van C", 7000, "C++", 2000);
        Employee a1 = new Administrator(4, "Pham Thi D", 6000, "HR");
        Employee a2 = new Administrator(5, "Hoang Van E", 6500, "Finance");

        company.addEmployee(p1);
        company.addEmployee(p2);
        company.addEmployee(pl1);
        company.addEmployee(a1);
        company.addEmployee(a2);

        System.out.println("Đã nhập dữ liệu mẫu thành công!");
        System.out.println("Danh sách nhân viên sau khi nhập mềm:");
        displayAllStaff();
    }
}
