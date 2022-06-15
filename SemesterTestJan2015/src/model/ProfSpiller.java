package model;

public class ProfSpiller extends Spiller {
    private double gameRate;

    public ProfSpiller(String name, int year, double gameRate) {
        super(name, year);
        this.gameRate = gameRate;
    }

    public double getGameRate() {
        return gameRate;
    }

    @Override
    public double kampHonorar() {
        double matchesParticipated = 0;
        int totalMatches = getParticipation().size();
        for(Deltagelse e : getParticipation()){
            if(!e.isCanceled()){
                matchesParticipated++;
            }
        }
        return matchesParticipated / totalMatches * gameRate;
    }


}
