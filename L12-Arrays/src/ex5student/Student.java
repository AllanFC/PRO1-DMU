package ex5student;

public class Student {
    private final String name;
    private final int[] grades;// containing the student's grades
    private int gradeCount;// the current number of grades

    private static final int MAX_GRADE_COUNT = 10;// maximum number of grades

    public Student(String name) {
        this.name = name;
        this.grades = new int[Student.MAX_GRADE_COUNT];
        this.gradeCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public int getGradeCount() {
        return this.gradeCount;
    }

    public void addGrade(int grade){
        if(gradeCount < MAX_GRADE_COUNT){
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Too many grades");
        }
    }

    public double gradeAverage(){
        int sum = 0;
        for(double e : grades){
            sum += e;
        }
        return sum / grades.length;
    }

    public int maxGrade(){
        int max = grades[0];
        for(int e : grades){
            if(e > max){
                max = e;
            }
        }
        return max;
    }

    public int minGrade(){
        int min = grades[0];
        for(int e : grades){
            if(e < min){
                min = e;
            }
        }
        return min;
    }

    public int[] getActualGrades(){
        int[] actualGrades = new int[gradeCount];
        for(int i = 0; i < gradeCount; i++){
            actualGrades[i] = grades[i];
        }
        return actualGrades;
    }
}
