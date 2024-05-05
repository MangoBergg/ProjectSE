package system.program.model;

import system.program.interfaces.IActivity;
import system.program.interfaces.IConsumedTime;

public class ConsumedTime implements IConsumedTime {
    
    public double time;
    public IActivity activity;

    public ConsumedTime(double time, IActivity activity) {
        this.time = time;
        this.activity = activity;
    }
}
