package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class ProjectSystemApp {

    public List<Project> projectList;
    public List<Activity> activityList;
    private boolean isLoggedIn = false;

    public ProjectSystemApp() {
        projectList = new ArrayList<>();
        activityList = new ArrayList<>();
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = true;
    }

    public void addProject(Project projectToAdd) throws Exception {
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
    }


}
