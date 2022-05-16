package Ex04;

import java.util.ArrayList;

public class Bag {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(String itemName){
        for (Item e : items){
            if(e.name.equals(itemName)){
                e.count++;
                return;
            }
        }
        Item newItem = new Item(itemName);
        items.add(newItem);
    }

    public int Count(String itemName){
        for(Item e : items){
            if(e.name.equals(itemName)){
                return e.count;
            }
        }
        return 0;
    }

    private static class Item{
        private String name;
        private int count = 1;
        public Item(String name){
            this.name = name;
        }
    }
}
