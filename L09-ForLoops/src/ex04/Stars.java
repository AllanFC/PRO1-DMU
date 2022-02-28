package ex04;


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
        int starCount = 1;
        int dashCount = 0;
        int half;
        boolean skip = false;
        if(rowCount % 2 == 0) {
            skip = true;
            half = rowCount / 2;
        } else {
            half = (int) Math.ceil(rowCount / 2.0);
            System.out.println(half);
        }
        for (int row = 1; row <= half; row++) {
            System.out.printf("%2d: ", row);
            if(row != 1){
                starCount += 2;
            }
            dashCount = (rowCount - starCount) / 2;

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
        for (int row = half + 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            if(skip){
                skip = false;
            } else {
                starCount -= 2;
            }
            dashCount = (rowCount - starCount) / 2;
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
