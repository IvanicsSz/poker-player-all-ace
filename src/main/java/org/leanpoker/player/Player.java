package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        System.out.println("CHECKPOINT 1");
        JsonObject gameState = request.getAsJsonObject();
        JsonArray player = gameState.getAsJsonArray("players");
        JsonObject ace = (JsonObject) player.get(2);
        System.out.println("NAME:" + ace.get("name"));
        JsonArray cards = ace.getAsJsonArray("hole_cards");
        String cardRank = null;
        String cardSuite = null;
        System.out.println("CHECKPOINT 2");
        Integer currentBuyIn = gameState.get("current_buy_in").getAsInt();

//        JsonObject cardRow1 = cards.get(0).getAsJsonObject();
//        JsonObject cardRow2 = cards.get(1).getAsJsonObject();
//        Card card1 = new Card(cardRow1.get("suit").toString(),cardRow1.get("rank").toString());
//        Card card2 = new Card(cardRow2.get("suit").toString(),cardRow2.get("rank").toString());
        //cards.get(1).
        //[{"rank":"7","suit":"spades"},{"rank":"4","suit":"diamonds"}]
       // System.out.println("card1 = " + card1);
       // System.out.println("card2 = " + card2);
        System.err.println(request);
        System.out.println("CHECKPOINT 3");

       // current_buy_in - players[in_action][bet] + minimum_raise
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
