package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        Integer result = null;

        System.out.println("CHECKPOINT 1");
        JsonObject gameState = request.getAsJsonObject();
        JsonArray player = gameState.getAsJsonArray("players");
        JsonObject ace = (JsonObject) player.get(2);
        System.out.println("NAME:" + ace.get("name"));
        JsonArray cards = ace.getAsJsonArray("hole_cards");
        JsonArray cardList = gameState.getAsJsonArray("community_cards");
        System.out.println("cardList = " + cardList);
        String cardRank = null;
        String cardSuite = null;
        System.out.println("CHECKPOINT 2");
        Integer currentBuyIn = gameState.get("current_buy_in").getAsInt();
        Integer bet = ((JsonObject) player.get(2)).get("bet").getAsInt();
        Integer raise = gameState.get("minimum_raise").getAsInt();
        String inAction = gameState.get("in_action").toString();
        result = 0;
        if (cards.get(0) != null && cards.get(1) != null) {
            JsonObject cardRow1 = cards.get(0).getAsJsonObject();
            JsonObject cardRow2 = cards.get(1).getAsJsonObject();
            System.out.println("CHECKPOINT 2.5");
                Card card1 = new Card(cardRow1.get("suit").getAsString(), cardRow1.get("rank").getAsString());
                Card card2 = new Card(cardRow2.get("suit").getAsString(), cardRow2.get("rank").getAsString());
                //cards.get(1).
                System.err.println(request);
                System.out.println("NEW LOGIC: " + (currentBuyIn - bet + raise));


            if (card1.getRank() > 6 && card2.getRank() > 11){
                result = currentBuyIn - bet + raise;
            }
            if (card1.getSuit() == card2.getSuit()){
                result = currentBuyIn - bet + raise;
            }

            if (card1.getRank() > 9 && card2.getRank() > 9) {
                result = currentBuyIn - bet + raise;
            }

            if (card1.getRank() > 9 && card2.getRank() > 9 && card1.getRank()  == card2.getRank()) {
                result = 1000;
            }

            System.out.println("CARD1 RANK: " + card1.getRank());
            System.out.println("CARD2 RANK: " + card2.getRank());
            System.out.println("result = " + result);

            System.out.println("check community cards");
            System.out.println(getCommunityCards(gameState));


            // current_buy_in - players[in_action][bet] + minimum_raise
            System.out.println("CHECKPOINT 3");
        }
            return result;
    }

    private static List<Card> getCommunityCards(JsonObject gameState) {
        List<Card> communityCards = new ArrayList<>();
        JsonArray cardList = gameState.getAsJsonArray("community_cards");
        System.err.println(cardList.size());
        if (cardList.size() < 1) {
            for (JsonElement cardRaw : cardList) {
                JsonObject card = cardRaw.getAsJsonObject();
                communityCards.add(new Card(card.get("suit").toString(), card.get("rank").toString()));
            }
        }
        return communityCards;
    }

    public static void showdown(JsonElement game) {
    }
}
