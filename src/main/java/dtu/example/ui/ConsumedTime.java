package dtu.example.ui;

import dtu.example.interfaces.IActivity;
import dtu.example.interfaces.IConsumedTime;

public class ConsumedTime implements IConsumedTime {
    
    public double time;
    public IActivity activity;

    public ConsumedTime(double time, IActivity activity) {
        this.time = time;
        this.activity = activity;
    }
}
