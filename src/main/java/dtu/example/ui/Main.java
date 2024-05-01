package dtu.example.ui;
import java.util.Scanner;



public class Main {

    private static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.launch();

    }

//    private static Employee loginService() {
//
//        while (true) {
//            System.out.println(Printer.BLUE + "Login with your ID:" + Printer.RESET);
//            String employeeID = inputScanner.nextLine();
//
//            if (employeeID.matches("^[a-z]{4}$")) {
//                //Printer.printAndWait(1500, Printer.GREEN + "Welcome employee " + employeeID + Printer.RESET);
//                Printer.clearScreen();
//                return new Employee(employeeID);
//            } else {
//                System.out.println(Printer.RED + "Invalid identification" + Printer.RESET);
//                continue;
//            }
//        }
//
//    }
}
