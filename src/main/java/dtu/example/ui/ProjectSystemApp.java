package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;

public class ProjectSystemApp {

    public List<Project> projectList;
    private boolean isLoggedIn = false;

    public ProjectSystemApp() {
        projectList = new ArrayList<>();
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = true;
    }
}
