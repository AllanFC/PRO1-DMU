import java.util.ArrayList;

public class Ex01 {
    public enum Race {PUDDLE, BOKSER, TERRIER}

    public static void main(String[] args) {
        ArrayList<Hund> hunde = new ArrayList<>();
        Hund h1 = new Hund("Max", false, 5000, Race.BOKSER);
        Hund h2 = new Hund("Sir Duke", true, 15000, Race.PUDDLE);
        Hund h3 = new Hund("Emma", false, 7000, Race.TERRIER);
        Hund h4 = new Hund("Duddle", true, 14000, Race.PUDDLE);
        Hund h5 = new Hund("Chance", false, 6000, Race.BOKSER);
        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println(samletPris(hunde, Race.BOKSER));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race){
        int sum = 0;

        for(Hund e : hunde){
            if(e.getRace() == race){
                sum += e.getPris();
            }
        }
        return sum;
    }
}

class Hund {
    private String navn;
    private boolean stamtavle;
    private int pris;
    private Ex01.Race race;

    public Hund(String navn, Boolean stamtavle, int pris, Ex01.Race race){
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;
    }

    public int getPris() {
        return pris;
    }

    public Ex01.Race getRace() {
        return race;
    }
}
