package DemoSearching.binarysearch;

public class Kunde {
    private final String navn;
    private final int nummer;
    private final int køb;

    public Kunde(String navn, int nummer, int køb) {
        this.navn = navn;
        this.nummer = nummer;
        this.køb = køb;
    }

    public String getNavn() {
        return navn;
    }

    public int getNummer() {
        return nummer;
    }

    public int getKøb() {
        return køb;
    }

    @Override
    public String toString() {
        return navn + " (" + nummer + ", kr " + køb + ")";
    }
}
