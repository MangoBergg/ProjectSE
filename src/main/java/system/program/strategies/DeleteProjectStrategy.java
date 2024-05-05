package system.program.strategies;

import java.util.List;
import java.util.Scanner;

import system.program.interfaces.IActivity;
import system.program.interfaces.IEmployee;
import system.program.interfaces.IProject;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public class DeleteProjectStrategy implements UserActionStrategy {
    @Override
    public void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user) {
        try {
            System.out.println("Which project do you want to delete?: ");
            int projectNumber = Integer.parseInt(inputScanner.nextLine()) - 1;
    
            // Retrieve project list and validate the project number
            List<IProject> projectList = projectManagementApp.getProjectRepository().getProjectList();
            if (projectNumber < 0 || projectNumber >= projectList.size()) {
                throw new IndexOutOfBoundsException("Invalid project number.");
            }
    
            IProject project = projectList.get(projectNumber);
            List<IActivity> activityListGlobal = projectManagementApp.getActivityRepository().getActivityList();
            List<IActivity> activityListProject = project.getActivityList();
    
            // Iterator to avoid ConcurrentModificationException...
            activityListGlobal.removeIf(activityGlobal -> activityListProject.stream()
                    .anyMatch(activityProject -> activityProject.getName().equals(activityGlobal.getName())));

            activityListProject.clear();
            projectList.remove(projectNumber);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
}
