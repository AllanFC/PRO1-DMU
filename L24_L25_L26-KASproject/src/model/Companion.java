package model;

import java.util.ArrayList;

public class Companion {
    private final String name;

    Companion(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // association 0..* <--> 0..* Excursion
    private final ArrayList<Excursion> companionExcursions = new ArrayList<>();

    /**
     *
     * Pre: The Companion is not already connected to the Excursion
     */
    public void addExcursion(Excursion excursion){
        companionExcursions.add(excursion);
        excursion.companions().add(this);
    }
    // ---------------------------------------------------------------------------------------

    /**
     * Returns the price of all the Companions Excursions
     */
    public int totalExcursionPrice() {
        int sum = 0;
        for (Excursion e : companionExcursions) {
            sum += e.getPrice();
        }
        return sum;
    }
}
