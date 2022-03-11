package Ex0712_13_14;

public class Sequence {
    private int[] values;

    public Sequence(int size) {
        values = new int[size];
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
        boolean found = false;
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

}