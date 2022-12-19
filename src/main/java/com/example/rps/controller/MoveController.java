package com.example.rps.controller;

import com.example.rps.enums.MoveType;
import com.example.rps.service.MoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/move")
@Slf4j
public class MoveController {

    @Autowired
    private MoveService moveService;

    @PostMapping
    public String beginTurn(@RequestParam("type") MoveType playerMoveType) {
        log.info("Received request from Player with MoveType: {}", playerMoveType);
        String result = moveService.findWinner(playerMoveType);
        log.info("Result of the turn is: {}", result);
        return result;
    }
}
