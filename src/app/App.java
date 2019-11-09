package app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("test.dms");
        Scanner scan = new Scanner(file);
        scan.useDelimiter(";");
        while (scan.hasNext()) {
            String line = scan.next();
            CodeLine codeLine = new CodeLine(line);
            System.out.println("Code Line: " + codeLine);

        }
        scan.close();
    }
}