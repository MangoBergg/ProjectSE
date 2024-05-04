package dtu.example.interfaces;

import java.util.List;

import dtu.example.repositories.ActivityRepository;
import dtu.example.repositories.ProjectRepository;

public interface IProjectManagementApp {

    int generateProjectNumber();

    IProject createProject(String string) throws Exception;

    IActivity createActivity(String string, IProject project);

    IEmployee getEmployeeFromName(String employeeToFind) throws Exception;

    List<IEmployee> findFreeEmployees(IActivity activity);

    ProjectRepository getProjectRepository();
    ActivityRepository getActivityRepository();
}