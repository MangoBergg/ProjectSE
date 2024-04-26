package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    private boolean isLoggedIn = false;
    private boolean cancelProgram = false;
    private Scanner inputScanner;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();
        inputScanner = new Scanner(System.in);

    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = true;
    }



    // The following code is reused from Hubert's video
    public Project createProject(String string) throws Exception {
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        Project project = new Project(string);
        addProject(project);
        return project;
    }

    public void addProject(Project project) {
        projectList.add(project);
    }

    // The following code is reused from Hubert's video
    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }


    public void createActivity(String string, Project project) throws Exception {
        if (project.containsActivity(string)){
            throw new Exception("An activity named ’Activity’ already exists in this project");
        }
        Activity activity = new Activity(string);
        project.addActivity(activity);
    }










   /* public void addProject(Project projectToAdd) throws Exception {
        boolean canAppend = true;

        for (Project project : projectList) {
            if (Objects.equals(projectToAdd.getName(), project.getName())) {
                canAppend = false;
            }
        }

        if (canAppend) {
            projectList.add(projectToAdd);
        } else {
            throw new Exception("Project with that name exists");
        }
    }

    public boolean hasProjectWithName(Project testProject) {
        for (Project project : projectList) {
            if (Objects.equals(testProject.getName(), project.getName())) {
                return true;
            }
        }
        return false;
    }



    public void addActivity(Activity activityToAdd) throws Exception {
        boolean canAppend = true;

        for (Activity activity : activityList) {
            if (Objects.equals(activityToAdd.getName(), activity.getName())) {
                canAppend = false;
            }
        }

        if (canAppend) {
            activityList.add(activityToAdd);
        } else {
            throw new Exception("Activity with that name exists");
        }
    }

    public boolean hasActivityWithName(Activity testActivity) {
        for (Activity activity : activityList) {
            if (Objects.equals(testActivity.getName(), activity.getName())) {
                return true;
            }
        }
        return false;
    }*/

    public void launch(){
        while (!cancelProgram) {
            handleMainMenu();

        }

    }
    private int getInput(int numOptions) {
        int input = 0;
        do {
            try {
                input = inputScanner.nextInt();
                if (input >= 1 && input <= numOptions) {
                    return input;
                } else {
                    System.out.println("Invalid option. Please enter a number between 1 and " + numOptions + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                inputScanner.next(); // Clear buffer
            }
        } while (true);
    }
    public void handleMainMenu() {
        System.out.println(Printer.BLUE + "Project Management System for Softwarehuset A/S - Version ");
        System.out.println(
                Printer.GREEN + "(1)" + Printer.YELLOW + " Open Project System \n" +
                        Printer.GREEN + "(2)" + Printer.YELLOW + " Open Time System \n" +
                        Printer.GREEN + "(3)" + Printer.YELLOW + " View maintenance log\n" +
                        Printer.GREEN + "(4)" + Printer.YELLOW + " Close System" +
                        Printer.RESET
        );


        switch (getInput(4)) { //getInput(number of cases) to validate that input is legal.
            case 1:
//                projectManagementSystem.setState(ProjectManagementSystem.State.PROJECT_SYSTEM);
                break;
            case 2:
//                projectManagementSystem.setState(ProjectManagementSystem.State.TIME_SYSTEM);
                break;
            case 3:
//                projectManagementSystem.setState(ProjectManagementSystem.State.VIEW_CHANGE_LOG);
                break;
            case 4:
                cancelProgram = true;
                break;
        }
    }
}
