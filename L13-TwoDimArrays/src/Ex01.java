import java.lang.reflect.Array;

public class Ex01 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0, 4, 3, 9, 6},
                {1, 3, 5, 2, 2},
                {3, 3, 1, 0, 1},
                {0, 0, 9, 7, 1}
                };

        print(array);
        System.out.println("Sum of row: " + sumRow(array, 1));
        System.out.println("Sum of Col: " + sumColumn(array, 1));
        System.out.println("Sum of array: " + sum(array));

    }

    public static void print(int[][] array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) { // loops one row
                System.out.printf("%2d  ", array[row][col]);
            }
            System.out.println();  // new line after each row
        }
    }

    public static int getValueAt(int[][] array, int row, int col){
        return array[row][col];

    }
    public static void setValueAt(int[][] array, int row, int col, int value){
        array[row][col] = value;
    }

    public static int sumRow(int[][] array, int row){
        int sumRow = 0;
        for(int c = 0; c < array[row].length; c++){
            sumRow += array[row][c];
        }
        return sumRow;
    }

    public static int sumColumn(int[][] array, int col){
        int sumCol = 0;
        for(int r = 0; r < array.length; r++){
            sumCol += array[r][col];
        }
        return sumCol;
    }

    public static int sum(int[][] array){
        int sum = 0;
        for(int r = 0; r < array.length; r++){
            for(int c = 0; c < array[r].length; c++){
                sum += array[r][c];
            }
        }
        return sum;
    }
}
