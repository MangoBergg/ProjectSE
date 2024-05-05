package dtu.example.interfaces;

public interface IProjectFactory {

    IProject createProject(String string) throws Exception;

    int generateProjectNumber();

}