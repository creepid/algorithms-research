/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import by.creepid.algorithms.utils.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class HnCGameTest {

    private static final int GAME_ROUNDS = 1000;

    /**
     * Test of guessNumber method, of class HnCGame.
     */
    @Test
    public void testGuessNumber() {
        System.out.println("**** guessNumber ****");
        
        int n;
        int result;
        HnCGame game;

        for (int i = 0; i < GAME_ROUNDS; i++) {
            n = StdRandom.randInt(1, 1000);
            game = new HnCGame(n);
            result = game.guessNumber();
            assertNotEquals(0, result);
        }


    }
}