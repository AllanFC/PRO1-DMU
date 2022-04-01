package Exercise02;

public class Person {
    private String name;
    private String job;
    private boolean senior;

    public Person(String name, String job, boolean senior) {
        this.name = name;
        this.job = job;
        this.senior = senior;
    }

    public String toString() {
        String s = job + " " + name;
        if (senior) {
            s = s + " (senior)";
        }
        return s;
    }
}
