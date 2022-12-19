package com.example.rps.util;

import com.example.rps.enums.MoveType;
import org.junit.jupiter.api.Test;

import static com.example.rps.constants.MoveConstants.COMPUTER_WINS_MESSAGE;
import static com.example.rps.constants.MoveConstants.PLAYER_WINS_MESSAGE;
import static com.example.rps.constants.MoveConstants.TIE_MESSAGE;
import static org.junit.Assert.assertEquals;

public class MoveUtilTest {

    @Test
    void testCalculateWinnerInCaseOfTie() {
        String result = MoveUtil.calculateWinner(MoveType.ROCK, MoveType.ROCK);
        assertEquals(result, TIE_MESSAGE);
    }

    @Test
    void testCalculateWinnerWhenComputerWins() {
        String result = MoveUtil.calculateWinner(MoveType.ROCK, MoveType.SCISSORS);
        assertEquals(result, COMPUTER_WINS_MESSAGE);
    }

    @Test
    void testCalculateWinnerWhenPlayerWins() {
        String result = MoveUtil.calculateWinner(MoveType.ROCK, MoveType.PAPER);
        assertEquals(result, PLAYER_WINS_MESSAGE);
    }
}
