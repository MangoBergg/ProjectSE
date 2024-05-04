package dtu.example.ui;

import java.util.List;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectManagementApp;

import java.util.ArrayList;
import java.util.Calendar;

public class ProjectManagementApp implements IProjectManagementApp {

    public List<IProject> projectList = new ArrayList<>();
    public List<IActivity> activityList = new ArrayList<>();
    public List<IEmployee> employeeList = new ArrayList<>();
    private Calendar calendar;
    private int serialNumber = 1;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();
        calendar = Calendar.getInstance();
    }

    @Override
    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }

    @Override
    public IProject createProject(String string) throws Exception {
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        Project project = new Project(string, generateProjectNumber());
        projectList.add(project);
        return project;
    }

    @Override
    public IActivity createActivity(String string, IProject project) {
        //Pre-conditions
        assert(!string.isEmpty()) : "Name cannot be empty";
        assert(!project.containsActivity(string)) : "The activity already exists in this project";

        Activity activity = new Activity(string, project);
        activityList.add(activity);
        project.getActivityList().add(activity);
        activity.setParentProject(project);

        //Post-conditions
        assert(project.getActivityList().contains(activity)) : "The activity does not exist in activityList, which means it is not created";

        return activity;
    }

    @Override
    public IProject getProjectFromName(String projectToFind) throws Exception {
        for (IProject project : projectList) {
            if (project.getName().equals(projectToFind)) {
                return project;
            }
        }

        throw new Exception("That project doesn't exist in the system");
    }

    @Override
    public IActivity getActivityFromName(String activityToFind) throws Exception {
        List<IActivity> foundActivities = new ArrayList<>();

        for (IActivity activity : activityList) {
            if (activity.getName().equals(activityToFind)) {
                foundActivities.add(activity);
            }
        }

        if (foundActivities.size() > 1) {
            System.out.println("Which activity: " + activityToFind + " do you mean?");
            Printer.displayActivityOverview(foundActivities);
            

        } else if (foundActivities.size() == 1) {
            return foundActivities.get(0);
        }

        throw new Exception("That activity doesn't exist in the system");
    }

    @Override
    public IEmployee getEmployeeFromName(String employeeToFind) throws Exception {
        for (IEmployee employee : employeeList) {
            if (employee.getEmployeeID().equals(employeeToFind)) {
                return employee;
            }
        }

        throw new Exception("That employee doesn't exist in the system");
    }

    @Override
    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

    @Override
    public List<IEmployee> findFreeEmployees(IActivity activity) {
        // Pre-conditions
        assert !employeeList.isEmpty() : "There are no employees in the system";

        int[] startEndWeeks = activity.getStartEndWeeks();
        int startWeek = startEndWeeks[0];
        int endWeek = startEndWeeks[1];
        
        assert !(startWeek == 0 || endWeek == 0) : "Activity must have defined start and end weeks";
    
        List<IEmployee> returnList = new ArrayList<>();
        for (IEmployee employee : employeeList) {
            if (!activity.containsAssignedEmployee(employee)) {
                boolean isFree = true;
                for (Absence absence : employee.getAbsence()) {
                    if (absence == null || absence.absenceWeeks == null) { continue; }
    
                    int absenceStart = absence.absenceWeeks[0];
                    int absenceEnd = absence.absenceWeeks[1];
                    
                    if (!(absenceEnd <= startWeek || absenceStart >= endWeek)) {
                        isFree = false;
                        break;
                    }
                }
                if (isFree) { returnList.add(employee); }
            }
        } 
        
        // Post-condition
        assert !returnList.isEmpty() : "No employee was found for that activity";
        return returnList;
    }
}
