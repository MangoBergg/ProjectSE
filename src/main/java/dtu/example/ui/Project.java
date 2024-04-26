package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private int projectID;
    private List<Activity> activityList = new ArrayList<>();


    public Project(String string){
        this.name = string;
    }

    public String getName() {
        return name;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }


    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(a -> a.getName().equals(activityName));
    }

            /*throws Exception {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            throw new Exception("Give name");
        }

        this.projectID = 1;
    }

    public String getName() {
        return name;
    }*/
}
