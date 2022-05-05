package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IGameOwnershipService;
import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.entities.concretes.GameOwnership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/gameownerships")
@RequiredArgsConstructor
public class GameOwnershipController
{
    private final IGameOwnershipService gameOwnershipService;
    private final IIndividualUserService individualUserService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam int userId, @RequestParam int gameId)
    {
        var newGameOwnership = new GameOwnership(0, userId, gameId);

        var resultData = this.gameOwnershipService.add(newGameOwnership);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> remove(@RequestParam int gameOwnershipId)
    {
        var resultData = this.gameOwnershipService.getById(gameOwnershipId);
        var result = this.gameOwnershipService.remove(resultData.getData());

        if (result.isSuccess())
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallowned")
    public ResponseEntity<?> getAllOwned(@RequestParam int userId)
    {
        var userResultData = this.individualUserService.getByUserId(userId);

        if (userResultData.isSuccess())
        {
            var resultData = this.gameOwnershipService.getOwnedGames(userResultData.getData());

            if (resultData.isSuccess())
            {
                return new ResponseEntity<>(resultData, HttpStatus.OK);
            }

            return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userResultData, HttpStatus.BAD_REQUEST);
    }
}
