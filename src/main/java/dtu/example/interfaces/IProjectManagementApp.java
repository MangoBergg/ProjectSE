package dtu.example.interfaces;

import java.util.List;

public interface IProjectManagementApp {

    int generateProjectNumber();

    IProject createProject(String string) throws Exception;

    IActivity createActivity(String string, IProject project);

    IProject getProjectFromName(String projectToFind) throws Exception;

    IActivity getActivityFromName(String activityToFind) throws Exception;

    IEmployee getEmployeeFromName(String employeeToFind) throws Exception;

    boolean containsProject(String projectName);

    List<IEmployee> findFreeEmployees(IActivity activity);

}