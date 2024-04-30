package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;


public class Activity {

    private String name;
    private Project parentProject;
    private int[] startEndWeeks = new int[2];

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

    public void updateStartEndWeeks(int weekStart, int weekEnd) throws Exception {
        if (weekEnd < weekStart) {
            throw new Exception("End week cannot be before start week");
        } else {
            startEndWeeks[0] = weekStart;
            startEndWeeks[1] = weekEnd;
            parentProject.updateStartEndWeeks(weekStart, weekEnd);
        }
    }

    public int[] getStartEndWeeks() { 
        return startEndWeeks; 
    }
}