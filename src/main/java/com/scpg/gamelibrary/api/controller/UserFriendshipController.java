package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.business.abstracts.IUserFriendshipService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.entities.concretes.UserFriendship;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/userfriendships")
@RequiredArgsConstructor
public class UserFriendshipController
{
    private final IUserFriendshipService userFriendshipService;
    private final IIndividualUserService individualUserService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam int firstUserId, @RequestParam int secondUserId)
    {
        var userFriendship = new UserFriendship(0, firstUserId, secondUserId);

        var resultData = this.userFriendshipService.add(userFriendship);

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> remove(@RequestParam int userFriendshipId)
    {
        var resultData = this.userFriendshipService.getById(userFriendshipId);

        var result = this.userFriendshipService.remove(resultData.getData());

        if (result.isSuccess())
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallfriends")
    public ResponseEntity<?> getAllFriends(@RequestParam int userId)
    {
        var userResultData = this.individualUserService.getByUserId(userId);

        if (!userResultData.isSuccess())
        {
            return new ResponseEntity<>(userResultData, HttpStatus.BAD_REQUEST);
        }

        var resultData = this.userFriendshipService.getAllFriends(userResultData.getData());

        if (resultData.isSuccess())
        {
            return new ResponseEntity<>(resultData, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }
}
