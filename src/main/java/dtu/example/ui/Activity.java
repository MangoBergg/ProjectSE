package dtu.example.ui;

import java.util.Objects;

public class Activity {

    private String name;

    public Activity(String name) throws Exception {
        if (!Objects.equals(name, "")) {
            this.name = name;
        } else {
            throw new Exception("Give name");
        }
    }

    public String getName() {
        return name;
    }
}
