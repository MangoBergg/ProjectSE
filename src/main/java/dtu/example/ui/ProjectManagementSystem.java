package dtu.example.ui;

import java.util.Calendar;
import java.util.Scanner;

//import collection.Employee;
import dtu.example.ui.Printer;
import dtu.example.ui.Project;
//import collection.ProjectActivity;
import dtu.example.ui.ProjectManagementSystemHelper;
//import systeminformation.SystemInfo;

public class ProjectManagementSystem {

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

    // For maintainability:
    public ProjectManagementSystemHelper projectManagementSystemHelper;

    //Higher-ups:
//    public Employee user;
    public ProjectSystem projectSystem;
//    public TimeSystem timeSystem;
//    public SystemInfo systemInfo;

    // Control the flow:
    public State currentState = State.MAIN_MENU;
    public boolean cancelProgram = false;
    public Project openProject;
//    public ProjectActivity openActivity;

    public ProjectManagementSystem(Scanner inputScanner, ProjectSystem projectSystem){
        this.projectManagementSystemHelper = new ProjectManagementSystemHelper(this, inputScanner);
        
//        this.user = user;
          this.projectSystem = projectSystem;
//        this.timeSystem = timeSystem;
//        this.systemInfo = systemInfo;
        
//        syncProjectAndTimeSystem();
    }
    public ProjectManagementSystem(){
        this.projectManagementSystemHelper = new ProjectManagementSystemHelper();

    }

//    public void syncProjectAndTimeSystem() {
//        timeSystem.projectSystem = this.projectSystem;
//        projectSystem.timeSystem = this.timeSystem;
//    }

    public void setState(State state) {
        this.currentState = state;
    }

    //Returning from this method shuts down the program.
    public void launch() {

        while (!cancelProgram) {
            Printer.clearScreen();
            
            switch (currentState) {
                // Depth 0:
                case MAIN_MENU:
                    projectManagementSystemHelper.handleMainMenu();
                    break;

                // Depth 1:
                case PROJECT_SYSTEM:
                    //projectManagementSystemHelper.handleProjectSystem();
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
    
    public void shutdown() {
        cancelProgram = true;
    }

//    public int generateProjectNumber() {
//        //If serialNumber = 1 and year is 2024 then this method returns 24001.
//        int lastTwoYearDigits = systemInfo.calendar.get(Calendar.YEAR) % 100;
//        String formatYear = String.format("%02d", lastTwoYearDigits);
//        String formatSerial = String.format("%03d", systemInfo.serialNumber);
//        systemInfo.serialNumber++;
//        return Integer.parseInt(formatYear + formatSerial);
//    }
}
