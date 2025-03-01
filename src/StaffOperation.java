import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StaffOperation {

    public void displayStaffMember(List<StaffMember> staff) {
        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0, 30, 30);
        table.setColumnWidth(1, 10, 10);
        table.setColumnWidth(2, 20, 20);
        table.setColumnWidth(3, 20, 20);
        table.setColumnWidth(4, 15, 15);
        table.setColumnWidth(5, 10, 10);
        table.setColumnWidth(6, 10, 10);
        table.setColumnWidth(7, 10, 10);
        table.setColumnWidth(8, 20, 20);
        table.addCell("Type", cellStyle);
        table.addCell("ID", cellStyle);
        table.addCell("Name", cellStyle);
        table.addCell("Address", cellStyle);
        table.addCell("Salary", cellStyle);
        table.addCell("Bunus", cellStyle);
        table.addCell("Hour", cellStyle);
        table.addCell("Rate", cellStyle);
        table.addCell("Pay", cellStyle);

        staff.forEach(staffMember -> {
            if(staffMember instanceof Volunteer ){
                Volunteer volunteer = (Volunteer) staffMember;
                table.addCell("Volunteer", cellStyle);
                table.addCell(String.valueOf(volunteer.getId()), cellStyle);
                table.addCell(volunteer.getName(), cellStyle);
                table.addCell(volunteer.getAddress(), cellStyle);
                table.addCell(String.valueOf(volunteer.getSalary()) , cellStyle);
                table.addCell("---", cellStyle);
                table.addCell("---", cellStyle);
                table.addCell("---", cellStyle);
                table.addCell(String.valueOf(volunteer.pay()), cellStyle);

            } else if (staffMember instanceof SalaryEmployee) {
                SalaryEmployee salaryEmployee = (SalaryEmployee) staffMember;
                table.addCell("Salary Employee", cellStyle);
                table.addCell(String.valueOf(salaryEmployee.getId()), cellStyle);
                table.addCell(salaryEmployee.getName(), cellStyle);
                table.addCell(salaryEmployee.getAddress(), cellStyle);
                table.addCell(String.valueOf(salaryEmployee.getSalary()) , cellStyle);
                table.addCell(String.valueOf(salaryEmployee.getBunus()), cellStyle);
                table.addCell("---", cellStyle);
                table.addCell("---", cellStyle);
                table.addCell(String.valueOf(salaryEmployee.pay()), cellStyle);
            }else{
                HourlySalaryEmployee hourlySalaryEmployee = (HourlySalaryEmployee) staffMember;
                table.addCell("Hourly Salary Employee", cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getId()), cellStyle);
                table.addCell(hourlySalaryEmployee.getName(), cellStyle);
                table.addCell(hourlySalaryEmployee.getAddress(), cellStyle);
                table.addCell("---" , cellStyle);
                table.addCell("---" , cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getHourWorked()), cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getRate()), cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.pay()), cellStyle);
            }
        });
        System.out.println(table.render());
    }


    public void updateEmployeeById(Scanner sc, List<StaffMember> staff) {
        System.out.println("\n"+"=".repeat(20) + " Update Employee " + "=".repeat(20));
        System.out.print("==> Enter ID to update: ");
        int updateID = sc.nextInt();
        sc.nextLine();

        staff.stream()
                .filter(staffMember -> staffMember.getId() == updateID)
                .findFirst()
                .ifPresentOrElse(staffMember -> {

                    displayStaffMember(List.of(staffMember));

                    boolean updating = true;
                    while (updating) {
                        System.out.println("\nChoose one field to update:");
                        System.out.print("1. Name\t\t2. Address");

                        if (staffMember instanceof SalaryEmployee) {
                            System.out.print("\t\t3. Salary\t\t4. Bonus");
                        } else if (staffMember instanceof HourlySalaryEmployee) {
                            System.out.print("\t\t3. Hours Worked \t\t4. Hourly Rate");
                        } else if (staffMember instanceof Volunteer) {
                            System.out.print("\t\t3. Salary");
                        }
                        System.out.println("\t\t0. Cancel");

                        System.out.print("==> Select option: ");
                        int choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1 -> {
                                System.out.print("Enter New Name: ");
                                staffMember.setName(sc.nextLine());
                                System.out.println("* Name updated successfully! *");
                            }
                            case 2 -> {
                                System.out.print("Enter New Address: ");
                                staffMember.setAddress(sc.nextLine());
                                System.out.println("* Address updated successfully! *");
                            }
                            case 3 -> {
                                if (staffMember instanceof SalaryEmployee salaryEmployee) {
                                    System.out.print("Enter New Salary: ");
                                    salaryEmployee.setSalary(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println("* Salary updated successfully! *");
                                } else if (staffMember instanceof Volunteer volunteer) {
                                    System.out.print("Enter New Salary: ");
                                    volunteer.setSalary(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println("* Salary updated successfully! *");
                                } else if (staffMember instanceof HourlySalaryEmployee hourlyEmployee) {
                                    System.out.print("Enter New Hours Worked: ");
                                    hourlyEmployee.setHourWorked(sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("* Hours Worked updated successfully! *");
                                }
                            }
                            case 4 -> {
                                if (staffMember instanceof SalaryEmployee salaryEmployee) {
                                    System.out.print("Enter New Bonus: ");
                                    salaryEmployee.setBunus(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println("* Bonus updated successfully! *");
                                } else if (staffMember instanceof HourlySalaryEmployee hourlyEmployee) {
                                    System.out.print("Enter New Hourly Rate: ");
                                    hourlyEmployee.setRate(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println("* Hourly Rate updated successfully! *");
                                }
                            }
                            case 0 -> {
                                System.out.println("* Update operation cancelled. *");
                                updating = false;
                            }
                            default -> System.out.println("Invalid option. Please try again.");
                        }

                        displayStaffMember(List.of(staffMember));

                        if (choice != 0) {
                            System.out.print("Do you want to update another field? (yes/no): ");
                            String continueUpdate = sc.nextLine().trim().toLowerCase();
                            updating = continueUpdate.equals("yes");
                        }
                    }

                    System.out.println("* Employee update process completed! *");
                }, () -> System.out.println("* Employee with ID " + updateID + " not found! *"));
    }


    public void deleteEmployeeById(Scanner sc, List<StaffMember> staff) {
        System.out.println("=".repeat(40) + " Delete Employee " + "=".repeat(40));

        displayStaffMember(staff);

        System.out.print("==> Enter ID to delete: ");
        int deleteID = sc.nextInt();
        sc.nextLine();

        Optional<StaffMember> staffToDelete = staff.stream()
                .filter(staffMember -> staffMember.getId() == deleteID)
                .findFirst();

        staffToDelete.ifPresentOrElse(staffMember -> {
            System.out.println("\nSelected Employee:");
            displayStaffMember(List.of(staffMember));

            System.out.print("Are you sure you want to delete this employee? (yes/no): ");
            String confirm = sc.nextLine().trim().toLowerCase();

            if (confirm.equals("yes") || confirm.equals("y")) {
                staff.remove(staffMember);
                System.out.println("* Employee deleted successfully! *");

                if (staff.isEmpty()) {
                    System.out.println("* No employees remaining in the system. *");
                } else {
                    displayStaffMember(staff);
                }
            } else {
                System.out.println("* Deletion canceled. *");
            }

        }, () -> System.out.println("* Employee with ID " + deleteID + " not found! *"));
    }


    public void insertEmployee(Scanner sc, List<StaffMember> staff) {
        System.out.println("\n"+"=".repeat(20) + " Insert New Employee " + "=".repeat(20));

        Menu.insertEmployee();
        System.out.print("==> Enter type number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Address: ");
        String address = sc.nextLine();

        StaffMember newEmployee = null;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Salary (if applicable, else enter 0): ");
                double salary = sc.nextDouble();
                sc.nextLine();
                newEmployee = new Volunteer(id, name, address, salary);
            }
            case 2 -> {
                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                System.out.print("Enter Bonus: ");
                double bonus = sc.nextDouble();
                sc.nextLine();

                newEmployee = new SalaryEmployee(id, name, address, salary, bonus);
            }
            case 3 -> {
                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();

                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();

                newEmployee = new HourlySalaryEmployee(id, name, address, hours, rate);
            }
            default -> {
                System.out.println("* Invalid selection. Employee not added. *");
                return;
            }
        }

        staff.add(newEmployee);
        System.out.println("* Employee added successfully! *");

        displayStaffMember(staff);
    }


}
