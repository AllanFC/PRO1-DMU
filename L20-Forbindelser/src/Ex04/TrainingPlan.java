package Ex04;

import java.util.ArrayList;

public class TrainingPlan {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;

    public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    /*-----------------------------------------------------------------------*/

    private final ArrayList<Swimmer> Swimmers = new ArrayList<>();

    public ArrayList<Swimmer> getSwimmers() {
        return new ArrayList<>(Swimmers);
    }

    public Swimmer createSwimmer(String name, ArrayList<Double> laptimes) {
        Swimmer person = new Swimmer(name, laptimes);
        Swimmers.add(person);
        return person;
    }

}
