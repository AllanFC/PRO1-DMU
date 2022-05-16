import java.util.ArrayList;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of(
                "Hej", "med", "dig",
                "Hej", "med","dig", "selv"));

        System.out.println(findAllIndices(strings, "selv"));
    }

    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target){
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            String k = list.get(i);
            if(k.equals(target)){
                indexList.add(i);
            }
        }
        return indexList;
    }
}
