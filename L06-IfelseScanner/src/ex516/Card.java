package ex516;

import java.util.List;

public class Card {
    private String notation;
    private String card;
    private String faction; // Aka. called suit
    private List<Character> cardNumbers = List.of('2', '3', '4', '5', '6', '7', '8', '9');
    private List<Character> cardLetters = List.of('A', 'J', 'Q', 'K');
    private List<Character> factionValues = List.of('D', 'H', 'S', 'C');

    public Card(String notation) {
        this.notation = notation;
    }

    public String getDescription(){
        if(notation.length() < 4) {
            if (notation.length() == 3 && notation.charAt(0) == '1' && notation.charAt(1) == '0') {
                if (notation.charAt(2) == 'D') {
                    faction = "Diamonds";
                } else if (notation.charAt(2) == 'H') {
                    faction = "Hearts";
                } else if (notation.charAt(2) == 'S') {
                    faction = "Spades";
                } else if (notation.charAt(2) == 'C') {
                    faction = "Clubs";
                }
                card = "10";
                return card + " of " + faction;
            } else if (cardNumbers.contains(notation.charAt(0))) {
                card = "" + notation.charAt(0);
                if (notation.charAt(1) == 'D') {
                    faction = "Diamonds";
                } else if (notation.charAt(1) == 'H') {
                    faction = "Hearts";
                } else if (notation.charAt(1) == 'S') {
                    faction = "Spades";
                } else if (notation.charAt(1) == 'C') {
                    faction = "Clubs";
                }
                return card + " of " + faction;
            } else if (cardLetters.contains(notation.charAt(0))) {
                if (notation.charAt(0) == 'A') {
                    card = "Ace";
                } else if (notation.charAt(0) == 'J') {
                    card = "Jack";
                } else if (notation.charAt(0) == 'Q') {
                    card = "Queen";
                } else if (notation.charAt(0) == 'K') {
                    card = "King";
                }
                if (notation.charAt(1) == 'D') {
                    faction = "Diamonds";
                } else if (notation.charAt(1) == 'H') {
                    faction = "Hearts";
                } else if (notation.charAt(1) == 'S') {
                    faction = "Spades";
                } else if (notation.charAt(1) == 'C') {
                    faction = "Clubs";
                }
                return card + " of " + faction;
            }
        }

        return "Unknown";
    }

}
