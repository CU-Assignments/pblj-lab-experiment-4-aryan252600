import java.util.*;

class Card {
    String suit, rank;
    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardCollection {
    static Map<String, Set<Card>> cards = new HashMap<>();
    
    static void addCard(String rank, String suit) {
        cards.putIfAbsent(suit, new HashSet<>());
        Card card = new Card(rank, suit);
        if (!cards.get(suit).add(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        } else {
            System.out.println("Card added: " + card);
        }
    }
    
    static void findCardsBySuit(String suit) {
        if (cards.containsKey(suit) && !cards.get(suit).isEmpty()) {
            cards.get(suit).forEach(System.out::println);
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }
    
    static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            cards.values().forEach(set -> set.forEach(System.out::println));
        }
    }
    
    static void removeCard(String rank, String suit) {
        if (cards.containsKey(suit) && cards.get(suit).remove(new Card(rank, suit))) {
            System.out.println("Card removed: " + rank + " of " + suit);
        } else {
            System.out.println("Card not found.");
        }
    }
    
    public static void main(String[] args) {
        addCard("Ace", "Spades");
        addCard("King", "Hearts");
        addCard("10", "Diamonds");
        addCard("5", "Clubs");
        findCardsBySuit("Hearts");
        displayAllCards();
        addCard("King", "Hearts");
        removeCard("10", "Diamonds");
    }
}
