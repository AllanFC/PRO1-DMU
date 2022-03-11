package twodimarrayEXAMPLE;

import java.util.Arrays;

public class App1 {

    public static void main(String[] args) {
        int[][] table = new int[7][5]; // 7 rows, 5 columns

        table[5][3] = 7;

        // 0 <= row < table.length
        // table length is 7

        // 0 <= column < table[row].length,
        // table[row].length is 5 for all rows

        // print table
        System.out.println("table:");
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[0].length; c++) {
                System.out.print(table[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] graph = new int[4][]; // 4 rows, columns not defined yet
        // define columns
        graph[0] = new int[5];
        graph[1] = new int[4];
        graph[2] = new int[5];
        graph[3] = new int[2];

        // fill graph
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                graph[row][col] = (row + 1) * 10 + col;
            }
        }

        // print graph
        System.out.println("graph:");
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                System.out.printf("%2d ", graph[row][col]);
            }
            System.out.println();
        }
        System.out.println();

//        for (int[] rowInTable : graph) {
//            System.out.println(Arrays.toString(rowInTable));
//        }
    }
}
