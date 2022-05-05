package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IGameService;
import com.scpg.gamelibrary.entities.concretes.Game;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games")
@RequiredArgsConstructor
public class GameController
{
    private final IGameService gameService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Game game)
    {
        var resultData = this.gameService.add(game);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/removebyid")
    public ResponseEntity<?> add(@RequestParam int id)
    {
        var resultData = this.gameService.getById(id);
        var result = this.gameService.remove(resultData.getData());

        if (result.isSuccess())
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll()
    {
        var resultData = this.gameService.getAll();

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallbypublisherid")
    public ResponseEntity<?> getAllByPublisherId(@RequestParam int publisherId)
    {
        var resultData = this.gameService.getAllByPublisherId(publisherId);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallbynamecontains")
    public ResponseEntity<?> getAllByNameContains(@RequestParam String input)
    {
        var resultData = this.gameService.getAllByNameContains(input);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }
}
