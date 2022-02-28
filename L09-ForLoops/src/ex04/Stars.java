package ex04;

import javax.xml.stream.events.StartDocument;

public class Stars
{
    public void starExA(int rowCount)
    {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void starExB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = row;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void starExC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void starExD(int rowCount) {
        int starCount = 0;
        int dashCount = 0;
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            if(row == 1 || row == rowCount) {
                starCount = 1;
            } else if (row < rowCount / 2){
                starCount += 2;
            } else {
                starCount -= 2;
            }
            if(rowCount % 2 == 0) {
                dashCount = rowCount - 1 - starCount;
            } else {
                dashCount = rowCount - starCount;
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("-");
            }

            System.out.println();
        }
    }

}
