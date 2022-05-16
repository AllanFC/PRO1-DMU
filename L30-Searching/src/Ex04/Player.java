package Ex04;

public class Player{
    private String name;
    private int hieght;
    private int weight;
    private int scoredGoals;

    public Player(String name, int hieght, int weight, int scoredGoals) {
        this.name = name;
        this.hieght = hieght;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public String getName() {
        return name;
    }

    public int getHieght() {
        return hieght;
    }

    public int getWeight() {
        return weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", hieght=" + hieght +
                ", weight=" + weight +
                ", scoreGoals=" + scoredGoals;
    }

}
