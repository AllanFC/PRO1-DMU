package opgave2;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class Person {
    private final String name;
    private final int dayOfBirth; // 1..31
    private final int monthOfBirth; // 1..12
    private final int yearOfBirth; // 1900..2010

    public Person(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public void printPerson() {
        System.out.println(name + ", born " + yearOfBirth + "-" + monthOfBirth + "-" + dayOfBirth);
    }

    public int calcage(int year, int month, int day) {
        if(month > yearOfBirth || month == monthOfBirth && day < dayOfBirth){
            return year - yearOfBirth;
        }
        return year - yearOfBirth - 1;
    }

    public String leapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return year + " is a leap year";
        }
        return year + " is not a leap year";
    }
}
