package Ex0712_13_14;

public class Sequence {
    private int[] values;

    public Sequence(int size) {
        values = new int[size];
    }

    public Sequence(int[] array) {
        values = array;
    }

    public void set(int i, int n) {
        values[i] = n;
    }

    public int get(int i) {
        return values[i];
    }

    public int size() {
        return values.length;
    }

    public boolean equals(Sequence other){
        for(int i = 0; i < values.length; i++){
            if(values[i] != other.values[i]){
                return false;
            }
        }
        return true;
    }

    public boolean sameValues(Sequence other){
        boolean found;
        for(int i = 0; i < values.length; i++){
            found = false;
            for(int j = 0; j < other.values.length; j++){
                if(values[i] == other.values[j]){
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }

    public boolean isPermutationOf(Sequence other){
        if(values.length != other.values.length){
            return false;
        }
        int sum = 0, sum1 = 0;
        int multi = 1, multi1 = 1;

        for (int value : values) {
            sum += value;
            multi *= value;
        }
        for(int value : other.values){
            sum1 += value;
            multi1 *= value;
        }
        if(sum == sum1 && multi == multi1){
            return true;
        }
        return false;
    }

}