import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("Hans", "Viggo", "Jens", "Bente", "Bent"));
        System.out.println(names.size());
        names.add(2, "jane");
        System.out.println(names);
        names.remove(1);
        names.add(0, "Pia");
        names.add("Ib");
        System.out.println(names.size());
        names.set(2, "Hansi");
        System.out.println(names.size());
        System.out.println(names);

        for(int i = 0; i < names.size(); i++){
            System.out.print(names.get(i).length());
        }
        System.out.println();
        for(String e : names){
            System.out.print(e.length());
        }
    }
}
