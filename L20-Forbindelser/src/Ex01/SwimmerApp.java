package Ex01;

import java.util.ArrayList;
import java.util.List;


public class SwimmerApp {

    public static void main(String[] args) {
        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(jan);
        swimmers.add(bo);
        swimmers.add(mikkel);

        TrainingPlan plan1 = new TrainingPlan('A', 16, 10);
        TrainingPlan plan2 = new TrainingPlan('B', 10, 6);

        jan.setTrainingPlan(plan1);
        bo.setTrainingPlan(plan1);
        mikkel.setTrainingPlan(plan2);

        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
            System.out.printf("%s bruger %d timer i vandet og %d timer på styrketræning \n", s.getName(),
                    s.getTrainingPlan().getWeeklyWaterHours(), s.getTrainingPlan().getWeeklyStrengthHours());
            System.out.printf("%s bruger samlet %d på træning om ugen \n", s.getName(), s.allTrainingHours());
        }

    }
}
