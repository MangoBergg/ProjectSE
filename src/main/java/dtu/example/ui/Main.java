package dtu.example.ui;
import java.util.Scanner;


public class Main {
    private static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ErrorMessageHolder errorMessage = new ErrorMessageHolder();
        Employee user = loginService();
    
        Project project;
        Employee employee;

        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.employeeList.add(user);

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
                        projectManagementApp.createProject(inputScanner.nextLine());
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;   
                
                case 2:
                    try {
                        System.out.println("What project do you want to update the project manager?: ");
                        project = projectManagementApp.getProjectFromName(inputScanner.nextLine());
                        Printer.clearScreen();
                        projectManagementApp.displayEmployeeOverview();
                        System.out.println("What employee should be the project manager for the project: '" + project.getName() + "'?");
                        employee = projectManagementApp.getEmployeeFromName(inputScanner.nextLine());
                        project.setProjectManager(employee);
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
                        "1 - Add Project. 2 - Assign Project Manager."
        );
    }

    private static Employee loginService() {

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
    }
}
