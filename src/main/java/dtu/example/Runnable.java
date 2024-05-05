package dtu.example;

import java.util.Scanner;

import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IPrinter;
import dtu.example.model.Developer;
import dtu.example.model.Employee;
import dtu.example.model.ErrorMessageHolder;
import dtu.example.model.Printer;
import dtu.example.model.ProjectManagementApp;
import dtu.example.strategies.UserActionContext;

public class Runnable {
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        ErrorMessageHolder errorMessage = new ErrorMessageHolder();
        IEmployee user = loginService();

        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.getEmployeeRepository().addEmployee(user);

        try {
            projectManagementApp.getEmployeeRepository().addEmployee(new Developer("juba"));
            projectManagementApp.getEmployeeRepository().addEmployee(new Developer("nuba"));
            projectManagementApp.getEmployeeRepository().addEmployee(new Developer("kuba"));
            projectManagementApp.getEmployeeRepository().addEmployee(new Developer("puba"));
            projectManagementApp.getEmployeeRepository().addEmployee(new Developer("duba"));

            projectManagementApp.getActivityFactory().createActivity("Programming", projectManagementApp.getProjectFactory().createProject("Project1"));
            projectManagementApp.getActivityFactory().createActivity("Testing", projectManagementApp.getProjectRepository().getProjectFromName("Project1"));
            projectManagementApp.getActivityFactory().createActivity("Refactoring", projectManagementApp.getProjectRepository().getProjectFromName("Project1"));
            projectManagementApp.getActivityFactory().createActivity("Design", projectManagementApp.getProjectFactory().createProject("Project2"));
            projectManagementApp.getActivityFactory().createActivity("Testing", projectManagementApp.getProjectRepository().getProjectFromName("Project2"));
            projectManagementApp.getActivityFactory().createActivity("BusinessLogic", projectManagementApp.getProjectFactory().createProject("Project3"));
            projectManagementApp.getActivityFactory().createActivity("Meeting", projectManagementApp.getProjectRepository().getProjectFromName("Project3"));
            projectManagementApp.getActivityFactory().createActivity("Development", projectManagementApp.getProjectFactory().createProject("Project4"));
            projectManagementApp.getActivityFactory().createActivity("Software Requirements Specification", projectManagementApp.getProjectRepository().getProjectFromName("Project4"));
            projectManagementApp.getActivityFactory().createActivity("Customer wish", projectManagementApp.getProjectFactory().createProject("Project5"));
            projectManagementApp.getActivityFactory().createActivity("Planning", projectManagementApp.getProjectRepository().getProjectFromName("Project5"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserActionContext userActionContext = new UserActionContext();

        while (true) {
            Printer.clearScreen();

            if (!errorMessage.getErrorMessage().isEmpty()) {
                System.out.println(IPrinter.RED + errorMessage.getErrorMessage() + IPrinter.RESET);
                errorMessage.setErrorMessage("");
            }

            Printer.displayProjectOverview(projectManagementApp.getProjectRepository().getProjectList());
            Printer.displayChoices();

            int choice;
            try {
                choice = Integer.parseInt(inputScanner.nextLine());
                if (choice < 1 || choice > 10) {
                    throw new Exception("Input not valid choice");
                }
            } catch (Exception e) {
                errorMessage.setErrorMessage("Input Exception: " + e.getMessage());
                continue;
            }

            userActionContext.execute(choice, inputScanner, projectManagementApp, errorMessage, user);
        }
    }

    private static IEmployee loginService() {
        while (true) {
            System.out.println(IPrinter.BLUE + "Login with your ID:" + IPrinter.RESET);
            String employeeID = inputScanner.nextLine();

            if (employeeID.matches("^[a-z]{4}$")) {
                Printer.clearScreen();
                return new Employee(employeeID);
            } else {
                System.out.println(IPrinter.RED + "Invalid identification" + IPrinter.RESET);
            }
        }
    }
}
