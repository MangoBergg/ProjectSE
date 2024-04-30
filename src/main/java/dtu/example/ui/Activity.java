package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;


public class Activity {

    private String name;
    private Project parentProject;


    public Activity(String string, Project parentProject) {
        this.name = string;
        this.parentProject = parentProject;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setParentProject(Project project) {
        parentProject = project;
    }

    public Project getParentProject() {
        return parentProject;
    }
}