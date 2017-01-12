package org.leanpoker.player;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String suit;
    private int rank;


    private static final Map<String, Integer> alphabeticalRank = new HashMap<String, Integer>() {{
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};


    public Card(String suit, String rank) {
        this.suit = suit;

        if (alphabeticalRank.get(suit) != null) {
            this.rank = alphabeticalRank.get(suit);
        } else this.rank = Integer.parseInt(rank);
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
