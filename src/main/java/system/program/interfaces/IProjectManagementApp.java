package system.program.interfaces;

import java.util.List;

import system.program.repositories.ActivityRepository;
import system.program.repositories.EmployeeRepository;
import system.program.repositories.ProjectRepository;

public interface IProjectManagementApp {
    List<IEmployee> findFreeEmployees(IActivity activity);

    ProjectRepository getProjectRepository();
    ActivityRepository getActivityRepository();
    EmployeeRepository getEmployeeRepository();
    IProjectFactory getProjectFactory();
    IActivityFactory getActivityFactory();
}