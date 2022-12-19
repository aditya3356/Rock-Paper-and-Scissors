package com.example.rps.service;

import com.example.rps.enums.MoveType;
import org.springframework.stereotype.Service;

import static com.example.rps.util.MoveUtil.calculateWinner;
import static com.example.rps.util.MoveUtil.generateRandomMove;

@Service
public class MoveService {

    public String findWinner(MoveType playerMoveType) {
        MoveType computerMoveType = generateRandomMove();
        return calculateWinner(computerMoveType, playerMoveType);
    }
}
