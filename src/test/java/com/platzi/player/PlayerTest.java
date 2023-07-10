package com.platzi.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

    @Test
    public void loosesWhenDiceNumberIsTooLow() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);
        assertEquals(false, player.play());
    }

    @Test
    public void winsWhenDiceNumberIsBig() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        
        Player player = new Player(dice, 3);
        assertEquals(true, player.play());
    }

}
