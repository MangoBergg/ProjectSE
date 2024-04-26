package dtu.example.ui;
public class Printer {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public static void printAndWait(int millis, String print) {
        try {
            System.out.println(print);
            Thread.sleep(millis); //Sleep for some time to make the program feel real :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printAndWait2(int millis, String print) {
        try {
            System.out.print(print);
            Thread.sleep(millis); //Sleep for some time to make the program feel real :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printLine() {
        System.out.println(BLACK + "_______________________________________________________________________" + RESET);
    }

}