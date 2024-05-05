package dtu.example.model;

import java.util.List;

import dtu.example.factories.ActivityFactory;
import dtu.example.factories.ProjectFactory;
import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IActivityFactory;
import dtu.example.interfaces.IEmployee;
import dtu.example.interfaces.IProjectFactory;
import dtu.example.interfaces.IProjectManagementApp;
import dtu.example.repositories.ActivityRepository;
import dtu.example.repositories.EmployeeRepository;
import dtu.example.repositories.ProjectRepository;

import java.util.ArrayList;

public class ProjectManagementApp implements IProjectManagementApp {

    private ProjectRepository projectRepository;
    private ActivityRepository activityRepository;
    private EmployeeRepository employeeRepository;

    private IProjectFactory projectFactory;
    private IActivityFactory activityFactory;

    public ProjectManagementApp() {
        projectRepository = ProjectRepository.getInstance();
        activityRepository = ActivityRepository.getInstance();
        employeeRepository = EmployeeRepository.getInstance();
        projectFactory = new ProjectFactory();
        activityFactory = new ActivityFactory();
    }

    @Override
    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    @Override
    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    @Override
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public IProjectFactory getProjectFactory() {
        return projectFactory;
    }

    @Override
    public IActivityFactory getActivityFactory() {
        return activityFactory;
    }

    @Override
    public List<IEmployee> findFreeEmployees(IActivity activity) {
        // Pre-conditions
        assert !employeeRepository.getEmployeeList().isEmpty() : "There are no employees in the system";

        int[] startEndWeeks = activity.getStartEndWeeks();
        int startWeek = startEndWeeks[0];
        int endWeek = startEndWeeks[1];
        
        assert !(startWeek == 0 || endWeek == 0) : "Activity must have defined start and end weeks";
    
        List<IEmployee> returnList = new ArrayList<>();
        for (IEmployee employee : employeeRepository.getEmployeeList()) {
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
