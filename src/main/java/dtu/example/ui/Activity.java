package dtu.example.ui;

import java.util.Objects;

public class Activity {

    private String name;
    private int[] startEndWeeks  = new int[2];
    private Project parentProject;


    public Activity(String string){
        this.name = string;
    }

    public String getName() {
        return name;
    }





    /*public Activity(String name) throws Exception {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            throw new Exception("Give name");
        }
    }*/


}
