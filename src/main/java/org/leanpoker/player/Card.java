package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String rank;
    private int suit;


    private static final Map<String, Integer> alphabeticalSuit = new HashMap<String, Integer>() {{
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};


    public Card(String rank, String suit) {
        this.rank = rank;

        if (alphabeticalSuit.get(suit) != null) {
            this.suit = alphabeticalSuit.get(suit);
        } else this.suit = Integer.parseInt(suit);
    }

    public String getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
