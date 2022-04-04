package Ex04;


import java.util.ArrayList;
import java.util.List;


public class SwimmerApp {

    public static void main(String[] args) {
        TrainingPlan planA = new TrainingPlan('A', 16, 10);
        TrainingPlan planB = new TrainingPlan('B', 10, 6);

        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        planA.createSwimmer("jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        planA.createSwimmer("bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        planA.createSwimmer("mikkel", lapTimesMikkel);

        System.out.println("Swimmers of plan1");
        for(Swimmer e : planA.getSwimmers()){
            System.out.println(e.getName() + "'s bedste tid: " + e.bestLapTime());
            System.out.printf("%s bruger %d timer i vandet og %d timer på styrketræning \n", e.getName(),
                    planA.getWeeklyWaterHours(), planA.getWeeklyStrengthHours());
            System.out.printf("%s bruger samlet %d på træning om ugen \n", e.getName(), planA.getWeeklyWaterHours() + planA.getWeeklyStrengthHours());
        }
        System.out.println();
        System.out.println("Swimmers of plan2");
        for(Swimmer e : planB.getSwimmers()){
            System.out.println(e.getName() + "'s bedste tid: " + e.bestLapTime());
            System.out.printf("%s bruger %d timer i vandet og %d timer på styrketræning \n", e.getName(),
                    planB.getWeeklyWaterHours(), planB.getWeeklyStrengthHours());
            System.out.printf("%s bruger samlet %d på træning om ugen \n", e.getName(), planB.getWeeklyWaterHours() + planB.getWeeklyStrengthHours());
        }
    }
}
