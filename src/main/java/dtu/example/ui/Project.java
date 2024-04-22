package dtu.example.ui;

import java.util.Objects;

public class Project {
    private String name;
    private int projectID;

    public Project(String name) throws Exception {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            throw new Exception("Give name");
        }

        this.projectID = 1;
    }
}
