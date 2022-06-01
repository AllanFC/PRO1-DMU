package model;

public class FrivilligForening extends Frivillig {
    private final String foreningsNavn;
    private final int antalFrivillige;

    public FrivilligForening(String navn, String mobil, int maksAntalTimer,
                             String foreningsNavn, int antalFrivillige) {
        super(navn, mobil, maksAntalTimer);
        this.foreningsNavn = foreningsNavn;
        this.antalFrivillige = antalFrivillige;
    }

    public String getForeningsNavn() {
        return foreningsNavn;
    }

    public int getAntalFrivillige() {
        return antalFrivillige;
    }

    //-------------------------------------------------------------------------

    // Del af S8 (13 p)
    @Override
    public String gaveBeskrivelse() {
        if (this.getVagter().size() > 0)
            return this.getNavn() + "\t" + antalFrivillige + "\t" + foreningsNavn;
        else
            return this.getNavn() + "\t" + "0" + "\t" + foreningsNavn;
    }
}
