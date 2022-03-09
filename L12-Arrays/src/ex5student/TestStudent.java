package ex5student;

import java.util.Arrays;
import java.util.Random;

public class TestStudent {

    public static void main(String[] args) {
        Random rd = new Random();
        int rand;
        int[] grades = {-3, 0, 2, 4, 7, 10, 12};
        Student s1 = new Student("Hanne");
        Student s2 = new Student("Margrethe");

        System.out.println(s1.getName());
        System.out.println(s2.getName());

        for(int i = 0; i < 5; i++){
            rand = rd.nextInt(grades.length - 1);
            s1.addGrade(grades[rand]);
            rand = rd.nextInt(grades.length - 1);
            s2.addGrade(grades[rand]);
        }

        System.out.println(s1.gradeAverage());
        System.out.println(s1.maxGrade());
        System.out.println(s1.minGrade());
        System.out.println(Arrays.toString(s1.getActualGrades()));

        System.out.println(s2.gradeAverage());
        System.out.println(s2.maxGrade());
        System.out.println(s2.minGrade());
        System.out.println(Arrays.toString(s2.getActualGrades()));
    }
}
