package dtu.example.ui;
import java.util.Scanner;


public class Main {
    private static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ErrorMessageHolder errorMessage = new ErrorMessageHolder();
        Employee user = loginService();
    
        Project project;
        Activity activity;
        Employee employee;

        int int1;
        int int2;

        double double1;

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

                case 3:
                case 4:
                    try {
                        System.out.println("What project do you want to add an activity?: ");
                        project = projectManagementApp.getProjectFromName(inputScanner.nextLine());
                        Printer.clearScreen();
                        project.displayActivityOverview();
                        System.out.println("What do you want to name the activity to be added to: '" + project.getName() + "'?");
                        projectManagementApp.createActivity(inputScanner.nextLine(), project);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        Printer.clearScreen();
                        projectManagementApp.displayActivityOverview();
                        System.out.println("What activity do you want to update the weeks?: ");
                        activity = projectManagementApp.getActivityFromName(inputScanner.nextLine());
                        System.out.println("Current start end weeks is: " + activity.getStartEndWeeks()[0] + ", " + activity.getStartEndWeeks()[1]);
                        System.out.println("What should the start week be?");
                        int1 = Integer.parseInt(inputScanner.nextLine());
                        System.out.println("What should the end week be?");
                        int2 = Integer.parseInt(inputScanner.nextLine());
                        activity.updateStartEndWeeks(int1, int2);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        Printer.clearScreen();
                        projectManagementApp.displayActivityOverview();
                        System.out.println("What activity do you want to update the budgeted time?: ");
                        activity = projectManagementApp.getActivityFromName(inputScanner.nextLine());
                        System.out.println("Current budgeted time is: " + activity.getBudgetedTime());
                        System.out.println("What should the budgeted time be?");
                        double1 = Double.parseDouble(inputScanner.nextLine());
                        activity.updateBudgetedTime(double1);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        Printer.clearScreen();
                        projectManagementApp.displayActivityOverview();
                        System.out.println("What activity do you want to assign an employee?: ");
                        activity = projectManagementApp.getActivityFromName(inputScanner.nextLine());
                        Printer.clearScreen();
                        projectManagementApp.displayEmployeeOverview();
                        System.out.println("What employee should be added?");
                        employee = projectManagementApp.getEmployeeFromName(inputScanner.nextLine());
                        activity.assignEmployee(employee);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        Printer.clearScreen();
                        projectManagementApp.displayActivityOverview();
                        System.out.println("What activity do you want to find an employee for?: ");
                        activity = projectManagementApp.getActivityFromName(inputScanner.nextLine());
                        Printer.clearScreen();
                        projectManagementApp.displayEmployeeOverviewList(projectManagementApp.findFreeEmployees(activity));
                        System.out.println("Write any number to go back:");
                        inputScanner.nextLine();
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        Printer.clearScreen();
                        projectManagementApp.displayActivityOverview();
                        System.out.println("What activity do you want to register time to?: ");
                        activity = projectManagementApp.getActivityFromName(inputScanner.nextLine());
                        Printer.clearScreen();
                        System.out.println("How much time do you want to register?: ");
                        user.updateConsumedTime(Double.parseDouble(inputScanner.nextLine()), activity);
                    } catch (Exception e) {
                        errorMessage.setErrorMessage(e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        Printer.clearScreen();
                        System.out.println("What's the reason for your absence?: ");
                        String reason = inputScanner.nextLine();
                        System.out.println("What is the starting week of your absence?: ");
                        int1 = Integer.parseInt(inputScanner.nextLine());
                        System.out.println("What is the end week of your absence?: ");
                        int2 = Integer.parseInt(inputScanner.nextLine());
                        user.registerAbsence(reason, int1, int2);
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
                        "1 - Add Project. 2 - Assign Project Manager. 3 - Get Status Report \n" +
                        "4 - Create Activity. 5 - Change Start and End Weeks. 6 - Change Budgeted Time \n" + 
                        "7 - Assign Employee to Activity. 8 - Find Free Employee \n" + 
                        "9 - Register Consumed Time. 10 - Register Absence"
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
