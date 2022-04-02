package demospecifications;

public class App {

    public static void main(String[] args) {
        int year = 2020;
        System.out.println(year + " is leap year? " + App.isLeapYear(year));
        System.out.println();

        System.out.println("Month: length");
        for (int i = 0; i <= 12; i++) {
            System.out.printf("%5d: %2d\n", i, App.monthLength(i, year));
        }
    }

    /**
     * Return true, if the year is a leap year.<br />
     * Pre: year > 1582.
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Return the length of the month in the year.<br/>
     * Pre: 1 <= month <= 12, year > 1582.<br/>
     * Note: The Gregorian calendar rule for leap years is used.
     */
    public static int monthLength(int month, int year) {
        int length = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            length = 30;
        } else if (month == 2) {
            if (App.isLeapYear(year)) {
                length = 29;
            } else {
                length = 28;
            }
        }
        return length;
    }
}
