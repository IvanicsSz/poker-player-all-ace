package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testBetRequest() throws Exception {


        String json = "{\"game_state\":" +
                "{\"tournament_id\":\"586e79d9037db5000403d046\",\"game_id\":\"58774a42c441a9000400001d\",\"round\":0,\"" +
                "players\":\"" +
                "[" +
                "{\"name\":\"Royal Bluff\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"Default Python folding player +1\",\"id\":0}," +
                "{\"name\":\"Back Street Boys and Mark\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"EXCEPTION\",\"id\":1}," +
                "{\"name\":\"all ace\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"Default Java folding player\",\"id\":2}," +
                "{\"name\":\"Ace Of Spades\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"Default Java folding player\",\"id\":3}," +
                "{\"name\":\"ZB ZS\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"_ZB.ZS\",\"id\":4}," +
                "{\"name\":\"weneverwonanything\",\"stack\":1000,\"status\":\"active\",\"bet\":0,\"hole_cards\":[],\"time_used\":0,\"version\":\"Default Python folding player\",\"id\":5}" +
                "]," +
                "\"small_blind\":2,\"big_blind\":4,\"orbits\":0,\"dealer\":4,\"community_cards\":[],\"current_buy_in\":0,\"pot\":0}}";
        JsonElement jsonElement = new JsonParser().parse(json);
        //Player.betRequest(new JsonParser().parse(req.getParameter("game_state")));
        assertEquals(1000, Player.betRequest(jsonElement));

    }
}
