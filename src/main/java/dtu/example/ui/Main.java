package dtu.example.ui;
import java.util.Scanner;

public class Main {
    
    private static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Employee user = loginService();
        
        Employee employee;
        String employeeID;
        
        Project project;
        String projectName;
        
        Activity activity;
        String activityName;
        
        int int1;
        int int2;

        ProjectManagementApp projectManagementApp = new ProjectManagementApp();


        while(true) {
            System.out.println("1 - Add Project");
            System.out.println("2 - Assign Project Manager to Project");
            System.out.println("3 - Add Activity to Project");
            System.out.println("4 - Get Status Report for a Project");
            System.out.println("5 - Assign Employee to Activity");
            System.out.println("6 - Change the Start-and-End Dates of an Activity");
            System.out.println("7 - Change the Budgeted Time of an Activity");
            System.out.println("8 - Find Free Employee");
            System.out.println("9 - Register Time Consumption");
            System.out.println("10 - Register Absence");
            System.out.println("11 - Print Overview of Projects");
            System.out.println("12 - Print Overview of Activites");
            
            int choice = Integer.parseInt(inputScanner.nextLine());
            switch (choice) {
                case 1:

                    try {
                        System.out.println("Give a title for the project: ");
                        projectName = inputScanner.nextLine();
                        projectManagementApp.createProject(projectName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;   
                
                case 2:
                    System.out.println("Give a title for the project: ");
                    projectName = inputScanner.nextLine();
                    
                    System.out.println("What employee should be the Project Manager?: ");
                    employeeID = inputScanner.nextLine();   

                    try {
                        project = projectManagementApp.getProject(projectName);
                        employee = projectManagementApp.getEmployee(employeeID);
                        project.setProjectManager(employee);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("Give a title for the activity: ");
                    activityName = inputScanner.nextLine();
                    try {
                        System.out.println("What project do you want to add to?: ");
                        project = projectManagementApp.getProject(inputScanner.nextLine());
                        projectManagementApp.createActivity(activityName, project);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:

                case 5:
                    System.out.println("Give a title for the project: ");
                    activityName = inputScanner.nextLine();
                    
                    System.out.println("What employee should be added?: ");
                    employeeID = inputScanner.nextLine();

                    try {
                        activity = projectManagementApp.getActivity(activityName);
                        employee = projectManagementApp.getEmployee(employeeID);
                        activity.assignEmployee(employee);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("What's the name of the activity?: ");
                    activityName = inputScanner.nextLine();
                    System.out.println("Provide start week: ");
                    int1 = Integer.parseInt(inputScanner.nextLine());
                    System.out.println("Provide end week: ");
                    int2 = Integer.parseInt(inputScanner.nextLine());

                    try {
                        activity = projectManagementApp.getActivity(activityName);
                        activity.updateStartEndWeeks(int1, int2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("What's the name of the activity?: ");
                    activityName = inputScanner.nextLine();
                    System.out.println("Provide a budgeted time: ");
                    int1 = Integer.parseInt(inputScanner.nextLine());

                    try {
                        activity = projectManagementApp.getActivity(activityName);
                        activity.updateBudgetedTime(int1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:

                default:
                    System.out.println("Not a valid choice");
            }
        }
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
