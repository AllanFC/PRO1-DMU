package opgave2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Karsten", "Eriksen", 35);
        e1.setTrainee(true);
        e1.printEmployee();
        e1.birthday();
        System.out.println(e1.getAge());
        System.out.println(e1.getName());
        System.out.println(e1.getFirstName());
        System.out.println(e1.getLastName());

    }
}
