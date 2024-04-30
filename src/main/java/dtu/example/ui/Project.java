package dtu.example.ui;

public class Project {
    private String name;
    private int projectID;

    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public int getProjectID() {
        return projectID;
    }
}
