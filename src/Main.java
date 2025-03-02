
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main implements Color{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<StaffMember> staff = new ArrayList<>();
        staff.add(new SalaryEmployee(2, "sina", "kps", 500, 10));
        staff.add(new HourlySalaryEmployee(3, "nana", "pvh", 30, 10.50));
        staff.add(new Volunteer(1, "bora", "pp", 100));
        int id = 4;

        while (true) {
            try {
                Menu.staffMenu();
                System.out.print("==> Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\n" + "=".repeat(40) + " Insert Employee " + "=".repeat(40));
                        Menu.insertEmployee();
                        System.out.print("==> Enter type number: ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        switch (type) {
                            case 1:
                                System.out.println("==> Volunteer Employee <==");
                                System.out.println("ID: " + id);

                                System.out.print("==> Enter Name: ");
                                String volunteerName = sc.nextLine();

                                System.out.print("==> Enter Address: ");
                                String volunteerAddress = sc.nextLine();

                                System.out.print("==> Enter Salary: ");
                                int volunteerSalary = sc.nextInt();
                                sc.nextLine();

                                staff.add(new Volunteer(id, volunteerName, volunteerAddress, volunteerSalary));
                                id = id + 1;
                                System.out.println(GREEN+"* You added " + volunteerName + " of type Volunteer successfully! *"+RESET);
                                break;

                            case 2:
                                System.out.println("==> Salary Employee <==");
                                System.out.println("ID: " + id);

                                System.out.print("==> Enter Name: ");
                                String salaryName = sc.nextLine();

                                System.out.print("==> Enter Address: ");
                                String salaryAddress = sc.nextLine();

                                System.out.print("==> Enter Salary: ");
                                int salary = sc.nextInt();
                                sc.nextLine();

                                System.out.print("==> Enter Bonus: ");
                                int salaryBonus = sc.nextInt();
                                sc.nextLine();

                                staff.add(new SalaryEmployee(id, salaryName, salaryAddress, salary, salaryBonus));
                                id = id + 1;
                                System.out.println( GREEN +"* You added " + salaryName + " of type SalaryEmployee successfully! *" +RESET);
                                break;

                            case 3:
                                System.out.println("==> Hourly Employee <==");
                                System.out.println("ID: " + id);

                                System.out.print("==> Enter Name: ");
                                String hourlyName = sc.nextLine();

                                System.out.print("==> Enter Address: ");
                                String hourlyAddress = sc.nextLine();

                                System.out.print("==> Enter Hour: ");
                                int hourlyWork = sc.nextInt();
                                sc.nextLine();

                                System.out.print("==> Enter Rate: ");
                                double rate = sc.nextDouble();
                                sc.nextLine();

                                staff.add(new HourlySalaryEmployee(id, hourlyName, hourlyAddress, hourlyWork, rate));
                                id = id + 1;
                                System.out.println(GREEN+"* You added " + hourlyName + " of type HourlyEmployee successfully! *"+RESET);
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println(RED+"Invalid choice"+RESET);
                        }
                        break;

                    case 2:
                        StaffOperation staffOperation1 = new StaffOperation();
                        staffOperation1.updateEmployeeById(sc, staff);
                        break;

                    case 3:
                        System.out.println("=".repeat(40) + " Display Staff " + "=".repeat(40));
                        StaffOperation staffOperation = new StaffOperation();
                        staffOperation.displayStaffMemberPagination(staff);
                        break;

                    case 4:
                        StaffOperation staffOperation2 = new StaffOperation();
                        staffOperation2.deleteEmployeeById(sc, staff);
                        break;

                    case 5:
                        System.out.println(GREEN+"==> The program has exited. <=="+RESET);
                        System.exit(0);

                    default:
                        System.out.println(RED+"Invalid choice"+RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED+"Invalid input. Please enter a valid number."+RESET);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(RED+"An unexpected error occurred: " + e.getMessage() + RESET);
                sc.nextLine();
            }
        }
    }
}