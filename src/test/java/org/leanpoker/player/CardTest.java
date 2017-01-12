package org.leanpoker.player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getRank_LetterValue() throws Exception {
        Card card1 = new Card("spade", "K");
        assertEquals(13, card1.getRank());
    }

    @Test
    public void getRank_NumberValue() throws Exception {
        Card card1 = new Card("spade", "9");
        assertEquals(9, card1.getRank());
    }

    @Test
    public void getSuit() throws Exception {
        Card card1 = new Card("spade", "11");
        assertEquals("spade", card1.getSuit());
    }

}