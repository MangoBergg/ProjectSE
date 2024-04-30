package dtu.example.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class ProjectManagementApp {

    public List<Project> projectList;
    private Calendar calendar;
    private int serialNumber = 1;

    public ProjectManagementApp() {
        projectList = new ArrayList<>();
        calendar = Calendar.getInstance();
    }

    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }

    public void displayProjectOverview() {
        String contained = "";

        for (Project project : projectList) {
            contained += ("\n");
            contained += (Printer.PURPLE + "[" +  project.getProjectID() + "] " + Printer.GREEN + project.getName() + Printer.RESET + "   ");
        }

        if(!contained.isBlank()) {
            System.out.println(Printer.BLUE + "Following projects exist in the system:");
            Printer.printLine();
            System.out.println(contained);
            Printer.printLine();
        }
        else {
            System.out.println(Printer.BLUE + "There are no projects in the system");
        }
    }

    public Project createProject(String string) throws Exception {
        if (containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        Project project = new Project(string, generateProjectNumber());
        projectList.add(project);
        return project;
    }

    public boolean containsProject(String projectName) {
        return projectList.stream().anyMatch(p -> p.getName().equals(projectName));
    }

}
