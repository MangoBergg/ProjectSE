package dtu.example.factories;

import java.util.Calendar;

import dtu.example.interfaces.IProject;
import dtu.example.interfaces.IProjectFactory;
import dtu.example.model.Project;
import dtu.example.repositories.ProjectRepository;

public class ProjectFactory implements IProjectFactory {
    ProjectRepository projectRepository;
    private int serialNumber = 1;
    private Calendar calendar;

    public ProjectFactory() {
        calendar = Calendar.getInstance();
        projectRepository = ProjectRepository.getInstance();
    }

    @Override
    public IProject createProject(String string) throws Exception {
        if (string.isEmpty()) {
            throw new Exception("Give name");
        }
        if (projectRepository.containsProject(string)){
            throw new Exception("Project with that name already exists");
        }
        IProject project = new Project(string, generateProjectNumber());
        projectRepository.addProject(project);
        return project;
    }

    @Override
    public int generateProjectNumber() {
        //If serialNumber = 1 and year is 2024 then this method returns 24001.
        int lastTwoYearDigits = calendar.get(Calendar.YEAR) % 100;
        String formatYear = String.format("%02d", lastTwoYearDigits);
        String formatSerial = String.format("%03d", serialNumber);
        serialNumber++;
        return Integer.parseInt(formatYear + formatSerial);
    }
}
