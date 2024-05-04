package dtu.example.interfaces;

import java.util.List;

import dtu.example.factories.ActivityFactory;
import dtu.example.factories.ProjectFactory;
import dtu.example.repositories.ActivityRepository;
import dtu.example.repositories.EmployeeRepository;
import dtu.example.repositories.ProjectRepository;

public interface IProjectManagementApp {
    List<IEmployee> findFreeEmployees(IActivity activity);

    ProjectRepository getProjectRepository();
    ActivityRepository getActivityRepository();
    EmployeeRepository getEmployeeRepository();
    ProjectFactory getProjectFactory();
    ActivityFactory getActivityFactory();
}