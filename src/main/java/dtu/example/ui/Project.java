package dtu.example.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private String name;
    private int projectID;
    private List<Activity> activityList = new ArrayList<>();


    public Project(String string, int projectID){
        this.name = string;
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public int getProjectID(){
        return projectID;
    }

    public List<Activity> getActivityList(){
        return activityList;
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
