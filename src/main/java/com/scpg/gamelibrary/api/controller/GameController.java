package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IGameService;
import com.scpg.gamelibrary.entities.concretes.Game;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("api/games")
@RequiredArgsConstructor
public class GameController
{
    private final IGameService gameService;


    @GetMapping("/getall")
    public List<Game> getAll()
    {
        return this.gameService.getAll();
    }

}
