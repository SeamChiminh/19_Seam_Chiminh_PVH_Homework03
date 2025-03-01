import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

public class Menu {

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
