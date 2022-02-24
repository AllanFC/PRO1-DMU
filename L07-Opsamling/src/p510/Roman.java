package p510;

import java.util.ArrayList;
import java.util.List;

public class Roman {
    private int input;
    private int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private ArrayList<String> romanList;

    public Roman(int input){
        this.input = input;
        romanList = new ArrayList<>();
    }

    public String convertToRoman(){
        if(input > 0 && input < 4000) {
            for (int i = 0; i < values.length; i++) {
                while (input >= values[i]) {
                    input -= values[i];
                    romanList.add(romanNumbers[i]);
                }
            }
            return String.join("", romanList);
        }
        return "Number either too high or a negative or 0";
    }


/*
I 1
V 5
X 10
L 50
C 100
D 500
M 1,000 MCMXCVII
 */
}
