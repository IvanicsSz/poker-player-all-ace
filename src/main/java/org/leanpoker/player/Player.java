package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        //JsonElement jsonElement = new JsonParser().parse(request);


        JsonObject gameState = request.getAsJsonObject();
        JsonArray player = gameState.getAsJsonArray("players");
        JsonObject ace = (JsonObject) player.get(2);
        System.out.println("NAME:" + ace.get("name"));
        JsonArray cards = ace.getAsJsonArray("hole_cards");
        String cardRank = null;
        String cardSuite = null;

        for (int i = 0; i < cards.size(); i++) {
            JsonObject card = cards.get(i).getAsJsonObject();
            cardRank = card.get("rank").toString();
            cardSuite = card.get("suit").toString();
        }
        //cards.get(1).
        //[{"rank":"7","suit":"spades"},{"rank":"4","suit":"diamonds"}]
        System.out.println("cardSuite = " + cardSuite);
        System.out.println("cardRank = " + cardRank);
        System.err.println(cards);
        System.err.println(request);
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
