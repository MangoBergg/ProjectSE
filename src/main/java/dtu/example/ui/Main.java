package dtu.example.ui;
import java.util.Scanner;


public class Main {
    private static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ErrorMessageHolder errorMessage = new ErrorMessageHolder();
        //Employee user = loginService();

        String projectName;

        ProjectManagementApp projectManagementApp = new ProjectManagementApp();


        while(true) {
            Printer.clearScreen();
            
            if (errorMessage.getErrorMessage() != "") {
                System.out.println(Printer.RED + errorMessage.getErrorMessage());
                errorMessage.setErrorMessage("");
            }

            projectManagementApp.displayProjectOverview();
            displayChoices();
            
            int choice = Integer.parseInt(inputScanner.nextLine());
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Give a title for the project: ");
                        projectName = inputScanner.nextLine();
                        projectManagementApp.createProject(projectName);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;   

                default:
                    System.out.println("Not a valid choice");
            }
        }
    }

    private static void displayChoices() {
        System.out.println(Printer.RESET +
                        "1 - Add Project"
        );
    }

    /*private static Employee loginService() {

        while (true) {
            System.out.println(Printer.BLUE + "Login with your ID:" + Printer.RESET);
            String employeeID = inputScanner.nextLine();

            if (employeeID.matches("^[a-z]{4}$")) {
                //Printer.printAndWait(1500, Printer.GREEN + "Welcome employee " + employeeID + Printer.RESET);
                Printer.clearScreen();
                return new Employee(employeeID);
            } else {
                System.out.println(Printer.RED + "Invalid identification" + Printer.RESET);
                continue;
            }
        }
    }*/
}
