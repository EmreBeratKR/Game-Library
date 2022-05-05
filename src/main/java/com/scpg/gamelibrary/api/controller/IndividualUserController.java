package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/individualUsers")
@RequiredArgsConstructor
public class IndividualUserController
{
    private final IIndividualUserService individualUserService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody IndividualUser individualUser)
    {
        var dataResult = this.individualUserService.add(individualUser);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/removebyid")
    public ResponseEntity<?> removeById(@RequestParam int id)
    {
        var individualUser = this.individualUserService.getByUserId(id);
        var result = this.individualUserService.remove(individualUser);

        if (result.isSuccess())
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll()
    {
        var dataResult = this.individualUserService.getAll();

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.NO_CONTENT);
    }

}
