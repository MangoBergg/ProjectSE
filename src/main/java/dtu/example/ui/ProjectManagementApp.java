package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    private boolean isLoggedIn = false;
    private boolean cancelProgram = false;
    State currentState = State.MAIN_MENU;
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
            Printer.clearScreen();
            switch (currentState) {
                // Depth 0:
                case MAIN_MENU:
                    handleMainMenu();
                    break;

                // Depth 1:
                case PROJECT_SYSTEM:
                    handleProjectSystem();
                    break;

                case TIME_SYSTEM:
                    //projectManagementSystemHelper.handleTimeSystem();
                    break;

                case VIEW_CHANGE_LOG:
                    //projectManagementSystemHelper.handleViewChangeLog();
                    break;

                case OPENING_PROJECT:
                    //projectManagementSystemHelper.handleOpeningProject();
                    break;

                // Depth 2: (Project)
                case OPEN_PROJECT:
                    //projectManagementSystemHelper.handleOpenProject();
                    break;

                case OPENING_ACTIVITY:
                    //projectManagementSystemHelper.handleOpeningActivity();
                    break;

                // Depth 3: (ProjectActivity)
                case OPEN_ACTIVITY:
                    //projectManagementSystemHelper.handleOpenActiviy();

                    //Depth 2: (Time)
            }
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
    public enum State {
        MAIN_MENU,
        PROJECT_SYSTEM,
        TIME_SYSTEM,
        VIEW_CHANGE_LOG,
        OPENING_PROJECT,
        OPEN_PROJECT,
        OPENING_ACTIVITY,
        OPEN_ACTIVITY
    }
    public void setState(State state) {
        this.currentState = state;
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
                setState(State.PROJECT_SYSTEM);
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
    public void handleProjectSystem() {
        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);
        System.out.println(
            Printer.GREEN + "(1) " + Printer.YELLOW + "Create a new project." + Printer.RESET + "\n" +
            Printer.GREEN + "(2) " + Printer.YELLOW + "Open project" + Printer.RESET + "\n" +
            Printer.GREEN + "(3) " + Printer.YELLOW + "Back" + Printer.RESET
        );

        switch(getInput(3)) { //getInput(number of cases) to validate that input is legal.
            case 1:
                Printer.clearScreen();
                createProject(inputScanner);
                break;
            case 2:
                setState(State.OPENING_PROJECT);
                break;
            case 3:
                setState(State.MAIN_MENU);
                break;
        }
    }


    public void createProject(Scanner inputScanner) {
        String nameOfProject = "";
        inputScanner.nextLine();
        boolean uniqueName;

        do {
            uniqueName = true;
            System.out.println(Printer.BLUE + "Provide a name for the new project" + Printer.RESET);
            nameOfProject = inputScanner.nextLine();

            if (nameOfProject.isBlank()) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "You need to specify a name for the project - ");
                uniqueName = false;
            }

            if (!nameOfProject.matches("^[a-zA-Z0-9]{4,16}$")) { //Consists of 4 to 16 "normal"-characters
                Printer.clearScreen();
                System.out.println(Printer.RED + "Invalid name for the project - Project names should be 4-16 characters long without special characters.");
                uniqueName = false;
            }

            for (Project project : projectList) {
                if (project.getName().equals(nameOfProject)) {
                    Printer.clearScreen();
                    System.out.println(Printer.RED + "A project named '" + nameOfProject + "' already exists in the system - ");
                    uniqueName = false;
                    break;
                }
            }
        } while (!uniqueName);
        System.out.println(Printer.RED + "Project with name "+ nameOfProject + " is added to the system." + Printer.RESET);
        projectList.add(new Project(nameOfProject));
    }
}
