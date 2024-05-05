package system.program.strategies;

import java.util.Scanner;

import system.program.interfaces.IEmployee;
import system.program.model.ErrorMessageHolder;
import system.program.model.ProjectManagementApp;

public interface UserActionStrategy {
    void execute(Scanner inputScanner, ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessage, IEmployee user);
}
