import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class Menu {

    public static void employeeMenu(){
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

        System.out.println(table.render());
    }

    public static void insertEmployee(){
        System.out.println("Choose Type: ");

        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0, 20, 20);
        table.setColumnWidth(1, 20, 20);
        table.setColumnWidth(2, 20, 20);
        table.setColumnWidth(3, 10, 10);
        table.addCell("1. Volunteer", cellStyle);
        table.addCell("2. Salary Employee", cellStyle);
        table.addCell("3. Hourly Employee", cellStyle);
        table.addCell("4. Back", cellStyle);
        System.out.println(table.render());
    }

    public static void staffMenu(){
        System.out.println();
        System.out.println("""
                    ╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
                    ║                                               ★彡[STAFF MANAGEMENT SYSTEM]彡★                                       ║
                    ║=====================================================================================================================║
                    ║                                                                                                                     ║
                    ║   \t\t1. Insert Employee        \t\t2. Update Employee                 \t3. Display Employee                   ║
                    ║   \t\t4. Remove Employee         \t\t5. Exit                                                                   ║
                    ║                                                                                                                     ║
                    ║                                                                                                                     ║ 
                    ╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝""");


    }
}
