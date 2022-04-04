package Ex01;

import java.util.ArrayList;
import java.util.Collections;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan; //nullable

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    public TrainingPlan getTrainingPlan(){
        return trainingPlan;
    }

    /** Pre: This person is connected to a TrainingPlan. */
    public void removeTrainingPlan(){
        trainingPlan = null;
    }

    /** Pre: This person is not connected to a TrainingPlan. */
    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        return Collections.min(getLapTimes());
    }

    /**
     * Returns how many training hours the swimmer has each week.
     */
    public int allTrainingHours(){
        return trainingPlan.getWeeklyWaterHours() + trainingPlan.getWeeklyStrengthHours();
    }
}
