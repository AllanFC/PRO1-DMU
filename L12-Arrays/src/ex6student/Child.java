package ex6student;

public class Child {
    private final String name;
    private final double[] weights;// can contain weights for the first 11 years
    private int weightsCount;

    public Child(String name) {
        this.name = name;
        this.weights = new double[11];
        this.weightsCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double[] getWeights() {
        return this.weights;
    }

    public int getWeightsCount() {
        return this.weightsCount;
    }

    public double getWeightAtAge(int age){
        return weights[age - 1];
    }

    public void addWeight(double weight){
        weights[weightsCount] = weight;
        weightsCount++;
    }

    public double maxYearlyWeightGain(){
        double maxGain = 0;
        for(int i = 1; i < weightsCount; i++){
            if(weights[i] - weights[i-1] > maxGain){
                maxGain = weights[i] - weights[i-1];
            }
        }
        return maxGain;
    }
}
