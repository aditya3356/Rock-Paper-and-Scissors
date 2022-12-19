package com.example.rps.util;

import com.example.rps.enums.MoveType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.rps.constants.MoveConstants.COMPUTER_WINS_MESSAGE;
import static com.example.rps.constants.MoveConstants.PLAYER_WINS_MESSAGE;
import static com.example.rps.constants.MoveConstants.TIE_MESSAGE;

@Slf4j
public class MoveUtil {

    private static final Map<MoveType, MoveType> winnerMoveMap = new HashMap<MoveType, MoveType>() {{
        put(MoveType.ROCK, MoveType.PAPER);
        put(MoveType.PAPER, MoveType.SCISSORS);
        put(MoveType.SCISSORS, MoveType.ROCK);
    }};

    public static MoveType generateRandomMove() {
        MoveType[] moveTypes = MoveType.values();
        MoveType randomMoveType = moveTypes[new Random().nextInt(moveTypes.length)];
        log.info("Random generated MoveType: {}", randomMoveType);
        return randomMoveType;
    }

    public static String calculateWinner(MoveType computerMoveType, MoveType playerMoveType) {
        log.info("Finding winner for Computer MoveType: {} and Player MoveType: {}", computerMoveType, playerMoveType);

        if (computerMoveType == playerMoveType) {
            return TIE_MESSAGE;
        }

        if (winnerMoveMap.get(computerMoveType) == playerMoveType) {
            return PLAYER_WINS_MESSAGE;
        }

        return COMPUTER_WINS_MESSAGE;
    }
}
