package opgave2;

public class opgave2 {
    private int age;
    private final boolean male;

    public opgave2(int age, boolean male) {
        this.age = age;
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean isMale() {
        return male;
    }

    public String institution() {
        if (age == 0) {
            return "Home";
        } else if (age == 1 || age == 2) {
            return "Nusery";
        } else if (age >= 3 && age <= 5) {
            return "Kindergarden";
        } else if (age >= 6 && age <= 16) {
            return "School";
        } else if (age >= 17 && age < 130) {
            return "Out of school";
        } else {
            return "Dead";
        }
    }

    public String gender() {
        if (male) {
            return "Boy";
        }
        return "Girl";
    }

    public String team() {
        if (male && age < 8) {
            return "Young boys";
        } else if (male) {
            return "Cool boys";
        } else if (!male && age < 8) {
            return "Tumbling girls";
        } else {
            return "Springy girls";
        }
    }
}
