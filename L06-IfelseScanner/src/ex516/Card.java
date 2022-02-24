package ex516;

public class Card {
    private String notation;
    private String card;
    private String fact;

    public Card(String notation){
        this.notation = notation;
    }

    public String getDescription(){
        if(notation.length() == 3){
            card = notation.substring(0, 1);
            if(card != "10"){
                return "Unknown "
            }
            fact = notation.substring(2);

        }
        return null;
    }

}
