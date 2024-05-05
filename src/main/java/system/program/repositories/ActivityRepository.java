package system.program.repositories;

import java.util.ArrayList;
import java.util.List;

import system.program.interfaces.IActivity;
import system.program.model.Printer;


public class ActivityRepository {
    private static ActivityRepository instance;

    private List<IActivity> activityList = new ArrayList<>();

    private ActivityRepository(){}
    
    public static ActivityRepository getInstance() {
        if (instance == null) {
            instance = new ActivityRepository();
        }
        return instance;
    }

    public IActivity getActivityFromName(String activityToFind) throws Exception {
        List<IActivity> foundActivities = new ArrayList<>();

        for (IActivity activity : activityList) {
            if (activity.getName().equals(activityToFind)) {
                foundActivities.add(activity);
            }
        }

        if (foundActivities.size() > 1) {
            System.out.println("Which activity: " + activityToFind + " do you mean?");
            Printer.displayActivityOverview(foundActivities);
            

        } else if (foundActivities.size() == 1) {
            return foundActivities.get(0);
        }

        throw new Exception("That activity doesn't exist in the system");
    }

    public List<IActivity> getActivityList() {
        return activityList;
    }

    public void addActivity(IActivity activity) {
        activityList.add(activity);
    }

    public boolean containsActivity(String activityName) {
        return activityList.stream().anyMatch(p -> p.getName().equals(activityName));
    }

    public void reset() { //Only for testing purposes and should only be called in tests.
        instance = new ActivityRepository();
    }
}
