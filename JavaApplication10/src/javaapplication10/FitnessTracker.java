package javaapplication10;


import java.time.*;
/**
 *
 * @author child
 */
public class FitnessTracker {
    private String activityName;
    private int numMinute;
    private LocalDate date;
    
   /* FitnessTracker()
    {
        this.activityName = "running";
        this.numMinute = 0;
        this.date = LocalDate.of(2020, 1, 1);
    }*/
    
    FitnessTracker()
    {
        this("running", 0, LocalDate.of(2020, 1, 1));
    }
    
    FitnessTracker(String activityName,int numMinute, LocalDate date)
    {
        this.activityName = activityName;
        this.numMinute = numMinute;
        this.date = date;
    }
    
    
}
