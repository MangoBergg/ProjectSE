package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;

public class ProjectManagementApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    private boolean isLoggedIn = false;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();

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


    public Activity createActivity(String string, Project project) throws Exception {
        if (project.containsActivity(string)){
            throw new Exception("An activity named ’Activity’ already exists in this project");
        }

        Activity activity = new Activity(string);
        project.addActivity(activity);
        activity.parentProject = project;
        return activity;
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


}
