package dtu.example.ui;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    public List<Employee> employeeList;
    private boolean isLoggedIn = true;
    private boolean cancelProgram = false;
    State currentState = State.LOGIN_MENU;
    private Scanner inputScanner;
    private Calendar calendar;
    private Project openProject;
    private Activity openActivity;
    private int serialNumber = 1;

    public ProjectManagementApp() {
        employeeList = new ArrayList<>();
        projectList = new ArrayList<>();
        inputScanner = new Scanner(System.in);
        calendar = Calendar.getInstance();

    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = isLoggedIn;
    }




    public void addProject(Project project) {
        projectList.add(project);
    }

    // The following code is reused from Hubert's video
    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

    public boolean containsEmployee(String string) {
        return employeeList.stream().anyMatch(e -> e.getEmployeeID().equals(string));

    }

    public Activity createActivity(String string, Project project) throws Exception {
        if (project.containsActivity(string)){
            throw new Exception("An activity named ’Activity’ already exists in this project");
        }

        Activity activity = new Activity(string, project);
        project.addActivity(activity);
        activity.parentProject = project;
        return activity;
    }


    public void createEmployee(String string) {
        if (!containsEmployee(string)) {
            employeeList.add(new Employee(string));
        }
        //System.out.println(Printer.BLUE+"The employee "+string+" is logged in");
        Printer.clearScreen();
        setState(State.MAIN_MENU);
    }


    // The following code about the project is reused from Hubert's video
    public Project createProject(String string) throws Exception {
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        Project project = new Project(string, generateProjectNumber());
        addProject(project);
        return project;
    }






    // The following code is for the UI

    public void launch(){
        while (!cancelProgram) {
            Printer.clearScreen();
            switch (currentState) {
                // Depth 0:
                case LOGIN_MENU:
                    handleLoginMenu();
                    break;
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
                    handleOpeningProject();
                    break;

                case ASSIGN_EMPLOYEE:
                    handleAssignEmployee();
                    break;

                // Depth 2: (Project)
                case OPEN_PROJECT:
                    handleOpenProject();
                    break;

                case OPENING_ACTIVITY:
                    handleOpeningActivity();
                    break;

                // Depth 3: (ProjectActivity)
                case OPEN_ACTIVITY:
                    handleOpenActivity();

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
        LOGIN_MENU ,
        MAIN_MENU,
        PROJECT_SYSTEM,
        TIME_SYSTEM,
        VIEW_CHANGE_LOG,
        OPENING_PROJECT,
        ASSIGN_EMPLOYEE,
        OPEN_PROJECT,
        OPENING_ACTIVITY,
        OPEN_ACTIVITY
    }
    public void setState(State state) {
        this.currentState = state;
    }

    public void handleLoginMenu()  {

        while(true) {
            System.out.println(Printer.BLUE + "Login with your ID:" + Printer.RESET);
            String employeeID = inputScanner.nextLine();

            if(employeeID.matches("^[a-z]{4}$")) {
                //Printer.printAndWait(1500, Printer.GREEN + "Welcome employee " + employeeID + Printer.RESET);
                Printer.clearScreen();
                try {
                    createEmployee(employeeID);
                    login();
                    break;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(Printer.RED + "Invalid identification" + Printer.RESET);
                continue;
            }
        }

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
                setState(State.LOGIN_MENU);
                isLoggedIn = false;
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
    public void handleOpeningProject() {
        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);

        //Take input to open the correct project:
        String projectNumber;
        boolean projectFound = false;
        inputScanner.nextLine();

        while (!projectFound) {
            displayProjectOverview();
            System.out.println(Printer.BLUE + "Provide the ID of the project you want to open (or type 'back' to go back):" + Printer.RESET);
            projectNumber = inputScanner.nextLine();

            if (projectNumber.equalsIgnoreCase("back")) {
                setState(State.PROJECT_SYSTEM);
                return;
            }

            for (Project project : projectList) {
                if (String.valueOf(project.getProjectID()).equals(projectNumber)) {
                    openProject = project;
                    projectFound = true;
                    break;
                }
            }

            if (!projectFound) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "No project was found with that ID. Try again (or type 'back' to go back):" + Printer.RESET);
            }
        }
        setState(openProject == null ? State.PROJECT_SYSTEM : State.OPEN_PROJECT);

    }
    public void handleOpenProject() {
        displayProjectDetails(openProject);
        displayActivityOverview(openProject);
        System.out.println(
                Printer.GREEN + "(1) " + Printer.YELLOW + "Create a new activity" + Printer.RESET + "\n" +
                        Printer.GREEN + "(2) " + Printer.YELLOW + "Open activity" + Printer.RESET + "\n" +
                        Printer.GREEN + "(3) " + Printer.YELLOW + "Assign employee to activity" + Printer.RESET + "\n" +
                        Printer.GREEN + "(4) " + Printer.YELLOW + "Back" + Printer.RESET
        );

        switch (getInput(4)) {
            case 1: // Create Activity
                Printer.clearScreen();
                createActivity(openProject, inputScanner);
                break;
            case 2:
                // Open activity
                setState(State.OPENING_ACTIVITY);
                break;
            case 3: // Assign employee to activity
                inputScanner.nextLine();
                displayActivityOverview(openProject);
                setState(State.ASSIGN_EMPLOYEE);
                break;
            case 4: // Back
                openProject = null;
                setState(State.PROJECT_SYSTEM);
                break;
        }
    }
    public void handleAssignEmployee() {
        boolean activityFound = false;
        boolean employeeFound = false;
        boolean validInput = false;
        System.out.println(Printer.BLUE + "Type activity name followed by a , and then the employee ID to be assigned to the activity." + Printer.RESET);
        String temp = inputScanner.nextLine();
        String[] input = temp.split(",");
        try{
            if (input[0].matches("^[a-zA-Z0-9]{4,16}$")) { //Consists of 4 to 16 "normal"-characters
                if(input[1].matches("^[a-z]{4}$")){
                    validInput = true;
                }
            }
        }catch(Exception e){
            System.out.println(Printer.BLUE + "Invalid input" + Printer.RESET);
            return;
        }

        if(validInput) {
            for (Activity activity : openProject.getActivityList()) {
                if (String.valueOf(activity.getName()).equals(input[0])) {
                    openActivity = activity;
                    activityFound = true;
                    break;
                }
            }
            if (containsEmployee(input[1])) {
                employeeFound = true;
            }
            if (!activityFound) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "No activity was found with that name.");
            }
            if (!employeeFound) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "No employee was found with that ID.");
            }
            if (!activityFound || !employeeFound) {
                displayActivityOverview(openProject);
                System.out.println(Printer.RED + "Try again (or type 'back' to go back)." + Printer.RESET);
                if (inputScanner.nextLine().equalsIgnoreCase("back")) {
                    setState(State.OPEN_PROJECT);
                    return;
                }
            }
            if (activityFound && employeeFound) {
                try {
                    openActivity.assignEmployee(input[1]);
                    System.out.println(Printer.BLUE + "Employee with ID " + input[1] + " has been assigned to activity " + input[0] + Printer.RESET);
                    setState(State.OPEN_PROJECT);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }









    public void handleOpeningActivity() {
        System.out.println(Printer.BLUE + "Project Sub-system" + Printer.RESET);

        //Take input to open the correct project:
        String activityName;
        boolean activityFound = false;
        inputScanner.nextLine();

        while (!activityFound) {
            displayActivityOverview(openProject);
            System.out.println(Printer.BLUE + "Provide the name of the activity you want to open (or type 'back' to go back):" + Printer.RESET);
            activityName = inputScanner.nextLine();

            if (activityName.equalsIgnoreCase("back")) {
                setState(State.OPEN_PROJECT);
                return;
            }

            for (Activity activity : openProject.getActivityList()) {
                if (String.valueOf(activity.getName()).equals(activityName)) {
                    openActivity = activity;
                    activityFound = true;
                    break;
                }
            }

            if (!activityFound) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "No activity was found with that name. Try again (or type 'back' to go back):" + Printer.RESET);
            }
        }
        setState(openProject == null ? State.OPEN_PROJECT : State.OPEN_ACTIVITY);
    }
    public void handleOpenActivity() {
        displayActivityDetails(openActivity);
        displayActivityOverview(openProject);
        System.out.println(
                Printer.GREEN + "(1) " + Printer.YELLOW + "Change start and end weeks" + Printer.RESET + "\n" +
                        Printer.GREEN + "(2) " + Printer.YELLOW + "Change budgeted time" + Printer.RESET + "\n" +
                        Printer.GREEN + "(3) " + Printer.YELLOW + "Back" + Printer.RESET
        );

        switch (getInput(3)) {
            case 1:
                Printer.clearScreen();
                changeStartEndWeeks(openActivity, inputScanner);
                break;
            case 2:
                Printer.clearScreen();
                changeBudgetTime(openActivity, inputScanner);
                break;
            case 3: // Back
                openActivity = null;
                setState(State.OPEN_PROJECT);
                break;
        }
    }
    public void createActivity(Project openProject, Scanner inputScanner) {
        String nameOfActivity = "";
        inputScanner.nextLine();
        boolean uniqueName;

        do {
            uniqueName = true;
            System.out.println(Printer.BLUE + "Provide a name for the new activity" + Printer.RESET);
            nameOfActivity = inputScanner.nextLine();

            if (nameOfActivity.isBlank()) {
                Printer.clearScreen();
                System.out.println(Printer.RED + "You need to specify a name for the activity - ");
                uniqueName = false;
            }

            for (Activity activity : openProject.getActivityList()) {
                if (activity.getName().equals(nameOfActivity)) {
                    Printer.clearScreen();
                    System.out.println(Printer.RED + "An activity named '" + nameOfActivity + "' already exists in the system - ");
                    uniqueName = false;
                    break;
                }
            }
        } while(!uniqueName);

        openProject.addActivity(new Activity(nameOfActivity, openProject));
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
        projectList.add(new Project(nameOfProject, generateProjectNumber()));

    }
    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }
    public void changeStartEndWeeks(Activity openActivity, Scanner inputScanner) {
        inputScanner.nextLine();

        while (true) {
            System.out.println(Printer.BLUE + "Please input start and end weeks separated by a comma");
            String[] input = inputScanner.nextLine().split(",");

            if (input.length != 2) {
                System.out.println(Printer.RED + "Invalid input. Input should be two numbers separated by a comma.");
                continue;
            }

            try {
                int start = Integer.parseInt(input[0].trim());
                int end = Integer.parseInt(input[1].trim());

                if (start > end) {
                    System.out.println(Printer.RED + "Invalid input. The start week should be before the end week.");
                    continue;
                }

                openActivity.updateStartEndWeeks(start, end);

                openActivity.parentProject.updateStartEndWeeks(start, end);

                break;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(Printer.RED + "Please enter valid integers separated by a comma. Give new input." + Printer.RESET);
                continue;
            }
        }
    }
    public void changeBudgetTime(Activity openActivity, Scanner inputScanner) {

        inputScanner.nextLine();

        while (true) {
            System.out.println(Printer.BLUE + "Please input budgeted time in increments of 0.5 separated by a '.'");
            String input = inputScanner.nextLine();

            // Matches our format.
            if (input.matches("\\d+\\.0|\\d+\\.5")) { // REGEX FROM CHATGPT FROM PROMPT:
                // ^^
                //PROMPT: Write me regex to match "number1.number2" where number2 = 5 and number1 is any number.

                double budgetedTime = Double.parseDouble(input);
                try {
                    openActivity.updateBudgetedTime(budgetedTime);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Budgeted time set to: " + budgetedTime);
                break;
            } else {
                System.out.println("Invalid input. Please ensure your number is in increments of 0.5");
            }
        }
    }

    public void displayProjectOverview() {
        int i = 1;
        int j = 1;
        String contained = "";
        String notContained = "";
        for (Project project : projectList) {
            contained += ("\n");
            contained += (Printer.PURPLE + "[" +  project.getProjectID() + "] " + Printer.GREEN + project.getName() + Printer.RESET + "   ");
            i++;
            }
        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following projects exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no projects in the system");
        }
    }
    public void displayProjectDetails(Project project) {
        System.out.println(Printer.BLUE + "Project '" + Printer.PURPLE + project.getName() + Printer.BLUE + "': \n" +
                Printer.BLUE + "    Scheduled Weeks: " + Printer.PURPLE + "[" + project.getStartEndWeeks()[0] + " - " + project.getStartEndWeeks()[1] + "]\n"
        );
    }
    public void displayActivityOverview(Project project) {
        int i = 1;
        int j = 1;
        String contained = "";
        String notContained = "";

        for (Activity activity : project.getActivityList()) {
            contained += (Printer.PURPLE + "[" +  activity.getName() + "]\n");
            i++;
            }
            if(!contained.isBlank()){
                System.out.println(Printer.BLUE + "Following activities exist in the project:");
                System.out.print(contained);
            }else{
                System.out.println(Printer.BLUE + "There are no activities in the project " + project.getName());
            }
    }
    public void displayActivityDetails(Activity openActivity) {
        System.out.println(Printer.BLUE + "Activity '" + Printer.PURPLE + openActivity.getName() + Printer.BLUE + "': \n" +
                Printer.BLUE + "    Scheduled Weeks: " + Printer.PURPLE + "[" + openActivity.getStartEndWeeks()[0]+ " - " + openActivity.getStartEndWeeks()[1] + "]\n" +
                Printer.BLUE + "    Budget time: " + Printer.PURPLE + openActivity.getBudgetTime()
        );
    }

}
