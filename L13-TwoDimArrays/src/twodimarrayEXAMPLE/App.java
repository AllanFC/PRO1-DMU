package twodimarrayEXAMPLE;

public class App {

    public static void main(String[] args) {
        // Testing 5 soft drinks, grades from 7 testers
        int[][] grades = {
                //0  1  2  3  4 <- soft drink no.
                { 3, 4, 3, 2, 1 }, // tester no. 0  
                { 4, 1, 3, 3 },    // tester no. 1
                { 3, 1, 1, 1, 5 }, // tester no. 2
                { 2, 3, 3, 3, 2 }, // tester no. 3
                { 3, 3, 3 },       // tester no. 4
                { 4, 1, 1, 4, 4 }, // tester no. 5
                { 4, 2, 2, 3, 2 }  // tester no. 6
        };
        // 0 <= row < grades.length
        // 0 <= column < grades[row].length

        // Count of all grades
        int totalGradeCount = 0;
        for (int row = 0; row < grades.length; row++) {
            totalGradeCount += grades[row].length;
        }
        System.out.printf("Total number of grades is %d\n", totalGradeCount);

        // Sum of all the grades
        int totalGradeSum = 0;
        for (int row = 0; row < grades.length; row++) {
            for (int col = 0; col < grades[row].length; col++) {
                totalGradeSum += grades[row][col];
            }
        }
        System.out.printf("Sum of all grades is %d \n", totalGradeSum);
        System.out.printf("Average of all grades is %.2f \n\n",
                (double) totalGradeSum / totalGradeCount);

        // Average grade for each tester
        for (int row = 0; row < grades.length; row++) {
            int rowGradeSum = 0;
            for (int col = 0; col < grades[row].length; col++) {
                rowGradeSum += grades[row][col];
            }
            double testerAverage = (double) rowGradeSum / grades[row].length;
            System.out.printf("Average of grades for tester %d: %.2f.\n",
                    row, testerAverage);
        }
        System.out.println();

        // Average grade for each soft drink
        int drinkCount = 5; // can be calculated as max row length
        double[] drinkAverage = new double[drinkCount];
        for (int col = 0; col < drinkCount; col++) {
            int colGradeSum = 0;
            int colGradeCount = 0;
            for (int row = 0; row < grades.length; row++) {
                if (col < grades[row].length) {
                    colGradeSum += grades[row][col];
                    colGradeCount++;
                }
            }
            drinkAverage[col] = (double) colGradeSum / colGradeCount;
            System.out.printf("Average of grades for soft drink no. %d: %.2f.\n",
                    col, drinkAverage[col]);
        }
        System.out.println();

        // Best average
        double maxAverage = drinkAverage[0];
        int indexOfMax = 0;
        for (int i = 0; i < drinkAverage.length; i++) {
            if (drinkAverage[i] > maxAverage) {
                maxAverage = drinkAverage[i];
                indexOfMax = i;
            }
        }
        System.out.printf("Best soft drink is no. %d with average: %.2f\n",
                indexOfMax, maxAverage);
        System.out.println();
    }
}
