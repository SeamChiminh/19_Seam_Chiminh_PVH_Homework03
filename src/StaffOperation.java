import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StaffOperation implements Color{

    public void displayStaffMemberPagination(List<StaffMember> staff) {
        Scanner sc = new Scanner(System.in);
        int pageSize = 3;
        int currentPage = 0;
        int totalPages = (int) Math.ceil((double) staff.size() / pageSize);

        while (true) {

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
            table.addCell("Bonus", cellStyle);
            table.addCell("Hour", cellStyle);
            table.addCell("Rate", cellStyle);
            table.addCell("Pay", cellStyle);

            int start = currentPage * pageSize;
            int end = Math.min(start + pageSize, staff.size());

            for (int i = start; i < end; i++) {
                StaffMember staffMember = staff.get(i);
                if (staffMember instanceof Volunteer) {
                    Volunteer volunteer = (Volunteer) staffMember;
                    table.addCell(BLUE + "Volunteer" + RESET, cellStyle);
                    table.addCell(String.valueOf(volunteer.getId()), cellStyle);
                    table.addCell(GREEN + volunteer.getName().toUpperCase() + RESET, cellStyle);
                    table.addCell(volunteer.getAddress().toUpperCase(), cellStyle);
                    table.addCell(String.valueOf("$ " + volunteer.getSalary()), cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(PURPLE + "$ " + volunteer.pay() + RESET, cellStyle);

                } else if (staffMember instanceof SalaryEmployee) {
                    SalaryEmployee salaryEmployee = (SalaryEmployee) staffMember;
                    table.addCell(BLUE + "Salary Employee" + RESET, cellStyle);
                    table.addCell(String.valueOf(salaryEmployee.getId()), cellStyle);
                    table.addCell(GREEN + salaryEmployee.getName().toUpperCase() + RESET, cellStyle);
                    table.addCell(salaryEmployee.getAddress().toUpperCase(), cellStyle);
                    table.addCell(String.valueOf("$ " + salaryEmployee.getSalary()), cellStyle);
                    table.addCell(String.valueOf("$ " + salaryEmployee.getBunus()), cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(PURPLE + "$ " + salaryEmployee.pay() + RESET, cellStyle);
                } else {
                    HourlySalaryEmployee hourlySalaryEmployee = (HourlySalaryEmployee) staffMember;
                    table.addCell(BLUE + "Hourly Salary Employee" + RESET, cellStyle);
                    table.addCell(String.valueOf(hourlySalaryEmployee.getId()), cellStyle);
                    table.addCell(GREEN + hourlySalaryEmployee.getName().toUpperCase() + RESET, cellStyle);
                    table.addCell(hourlySalaryEmployee.getAddress().toUpperCase(), cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(RED + "---" + RESET, cellStyle);
                    table.addCell(String.valueOf(hourlySalaryEmployee.getHourWorked()), cellStyle);
                    table.addCell(String.valueOf(hourlySalaryEmployee.getRate()), cellStyle);
                    table.addCell(PURPLE + String.valueOf("$ " + hourlySalaryEmployee.pay()) + RESET, cellStyle);
                }
            }

            System.out.println(table.render());

            System.out.println("\nPage " + (currentPage + 1) + "/" + totalPages);
            System.out.println("1.First Page \t\t2.Next Page \t\t3.Previous Page \t\t4.Last Page \t\t5.Exit");
            System.out.print("==> Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    currentPage = 0;
                    break;

                case 2:
                    if (currentPage < totalPages - 1) {
                        currentPage++;
                    } else {
                        System.out.println("==> You are already on the last page.");
                    }
                    break;

                case 3:
                    if (currentPage > 0) {
                        currentPage--;
                    } else {
                        System.out.println("==> You are already on the first page.");
                    }
                    break;

                case 4:
                    currentPage = totalPages - 1;
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


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
                table.addCell(BLUE+ "Volunteer" +RESET, cellStyle);
                table.addCell(String.valueOf(volunteer.getId()), cellStyle);
                table.addCell(GREEN+ volunteer.getName().toUpperCase() +RESET, cellStyle);
                table.addCell(volunteer.getAddress().toUpperCase(), cellStyle);
                table.addCell(String.valueOf("$ "+volunteer.getSalary()) , cellStyle);
                table.addCell(RED+"---"+RESET, cellStyle);
                table.addCell(RED+"---"+RESET, cellStyle);
                table.addCell(RED+"---"+RESET, cellStyle);
                table.addCell(PURPLE+ "$ "+volunteer.pay() +RESET, cellStyle);

            } else if (staffMember instanceof SalaryEmployee) {
                SalaryEmployee salaryEmployee = (SalaryEmployee) staffMember;
                table.addCell(BLUE+"Salary Employee"+RESET, cellStyle);
                table.addCell(String.valueOf(salaryEmployee.getId()), cellStyle);
                table.addCell(GREEN+salaryEmployee.getName().toUpperCase()+RESET, cellStyle);
                table.addCell(salaryEmployee.getAddress().toUpperCase(), cellStyle);
                table.addCell(String.valueOf("$ "+salaryEmployee.getSalary()) , cellStyle);
                table.addCell(String.valueOf("$ "+salaryEmployee.getBunus()), cellStyle);
                table.addCell(RED+"---"+RESET, cellStyle);
                table.addCell(RED+"---"+RESET, cellStyle);
                table.addCell(PURPLE+ "$ "+salaryEmployee.pay() +RESET, cellStyle);
            }else{
                HourlySalaryEmployee hourlySalaryEmployee = (HourlySalaryEmployee) staffMember;
                table.addCell(BLUE+ "Hourly Salary Employee" +RESET, cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getId()), cellStyle);
                table.addCell(GREEN+hourlySalaryEmployee.getName().toUpperCase()+RESET, cellStyle);
                table.addCell(hourlySalaryEmployee.getAddress().toUpperCase(), cellStyle);
                table.addCell(RED+"---"+RESET , cellStyle);
                table.addCell(RED+"---"+RESET , cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getHourWorked()), cellStyle);
                table.addCell(String.valueOf(hourlySalaryEmployee.getRate()), cellStyle);
                table.addCell(PURPLE+String.valueOf("$ "+hourlySalaryEmployee.pay()) +RESET, cellStyle);
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
                                System.out.print("==> Enter New Name: ");
                                staffMember.setName(sc.nextLine());
                                System.out.println(GREEN+"* Name updated successfully! *"+RESET);
                            }
                            case 2 -> {
                                System.out.print("==> Enter New Address: ");
                                staffMember.setAddress(sc.nextLine());
                                System.out.println(GREEN+"* Address updated successfully! *"+RESET);
                            }
                            case 3 -> {
                                if (staffMember instanceof SalaryEmployee salaryEmployee) {
                                    System.out.print("==> Enter New Salary: ");
                                    salaryEmployee.setSalary(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println(GREEN+"* Salary updated successfully! *"+RESET);
                                } else if (staffMember instanceof Volunteer volunteer) {
                                    System.out.print("==> Enter New Salary: ");
                                    volunteer.setSalary(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println(GREEN+"* Salary updated successfully! *"+RESET);
                                } else if (staffMember instanceof HourlySalaryEmployee hourlyEmployee) {
                                    System.out.print("==> Enter New Hours Worked: ");
                                    hourlyEmployee.setHourWorked(sc.nextInt());
                                    sc.nextLine();
                                    System.out.println(GREEN+"* Hours Worked updated successfully! *"+RESET);
                                }
                            }
                            case 4 -> {
                                if (staffMember instanceof SalaryEmployee salaryEmployee) {
                                    System.out.print("==> Enter New Bonus: ");
                                    salaryEmployee.setBunus(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println(GREEN+"* Bonus updated successfully! *"+RESET);
                                } else if (staffMember instanceof HourlySalaryEmployee hourlyEmployee) {
                                    System.out.print("==> Enter New Hourly Rate: ");
                                    hourlyEmployee.setRate(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.println(GREEN+"* Hourly Rate updated successfully! *"+RESET);
                                }
                            }
                            case 0 -> {
                                System.out.println(GREEN+"* Update operation cancelled. *"+RESET);
                                updating = false;
                            }
                            default -> System.out.println(RED+"Invalid option. Please try again."+RESET);
                        }

                        displayStaffMember(List.of(staffMember));

                        if (choice != 0) {
                            System.out.print("Do you want to update another field? (yes/no): ");
                            String continueUpdate = sc.nextLine().trim().toLowerCase();
                            updating = continueUpdate.equals("yes");
                        }
                    }

                    System.out.println(GREEN+"* Employee update process completed! *"+RESET);
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
                System.out.println(GREEN+"* Employee deleted successfully! *"+RESET);

                if (staff.isEmpty()) {
                    System.out.println(YELLOW+"* No employees remaining in the system. *"+RESET);
                } else {
                    displayStaffMember(staff);
                }
            } else {
                System.out.println(YELLOW+"* Deletion canceled. *"+RESET);
            }

        }, () -> System.out.println(RED+"* Employee with ID " + deleteID + " not found! *"+RESET));
    }


}
