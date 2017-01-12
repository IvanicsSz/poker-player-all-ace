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
        String cards = ace.get("hole_cards").toString();
        System.err.println(cards);

        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
