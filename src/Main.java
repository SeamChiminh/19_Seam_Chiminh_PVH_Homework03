
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<StaffMember> staff = new ArrayList<>();
        staff.add(new SalaryEmployee(2, "sina", "kps", 500, 10));
        staff.add(new HourlySalaryEmployee(3, "nana", "pvh", 30, 5));
        staff.add(new Volunteer(1, "bora", "pp", 100));
        int id = 4;

        while (true) {
            Menu.staffMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n"+"=".repeat(40) + " Insert Employee " + "=".repeat(40));
                    Menu.insertEmployee();
                    System.out.print("==> Enter type number: ");
                    int type = sc.nextInt();
                    switch (type) {
                        case 1:
                            System.out.println("Volunteer Employee");
                            System.out.println("ID: " +id);
                            sc.nextLine();

                            System.out.print("==> Enter Name: ");
                            String volunteerName = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String volunteerAddress = sc.nextLine();

                            System.out.print("Enter Salary: ");
                            int volunteerSalary = sc.nextInt();

                            staff.add(new Volunteer(id, volunteerName, volunteerAddress, volunteerSalary));
                            id = id + 1;
                            System.out.println("* You added " +volunteerName + " " + "of type Volunteer successfully! *");
                            break;
                        case 2:
                            System.out.println("Salary Employee");
                            System.out.println("ID: " + id);
                            sc.nextLine();
                            System.out.print("==> Enter Name: ");
                            String salaryName = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String salaryAddress = sc.nextLine();

                            System.out.print("Enter Salary: ");
                            int salary = sc.nextInt();

                            System.out.print("Enter Bunus: ");
                            int salaryBunus = sc.nextInt();

                            staff.add(new SalaryEmployee(id, salaryName, salaryAddress, salary, salaryBunus));
                            id = id + 1;
                            System.out.println("* You added " +salaryName + " " + "of type SalaryEmployee successfully! *");
                            break;
                        case 3:
                            System.out.println("Hourly Employee");
                            System.out.println("ID: " + id);
                            sc.nextLine();
                            System.out.print("==> Enter Name: ");
                            String hourlyName = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String hourlyAddress = sc.nextLine();

                            System.out.print("Enter Hour: ");
                            int hourlyWork = sc.nextInt();

                            System.out.print("Enter Rate: ");
                            double rate = sc.nextDouble();

                            staff.add(new HourlySalaryEmployee(id, hourlyName, hourlyAddress, hourlyWork, rate));
                            id = id + 1;
                            System.out.println("* You added " + hourlyName + " " + "of type SalaryEmployee successfully! *");
                            break;
                        case 4: break;
                        default:
                                System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                        StaffOperation staffOperation1 = new StaffOperation();
                        staffOperation1.updateEmployeeById(sc, staff);
                        break;
                case 3:
                    System.out.println("=".repeat(40) + " Display Staff " +"=".repeat(40));
                    StaffOperation staffOperation = new StaffOperation();
                    staffOperation.displayStaffMember(staff);

                    break;
                case 4:
                    StaffOperation staffOperation2 = new StaffOperation();
                    staffOperation2.deleteEmployeeById(sc, staff);
                    break;
                case 5:
                    System.out.println("The program has exit");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}