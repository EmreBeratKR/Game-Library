package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        var resultData = this.individualUserService.getByUserId(id);

        var result = this.individualUserService.remove(resultData.getData());

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

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id)
    {
        var dataResult = this.individualUserService.getByUserId(id);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyusername")
    public ResponseEntity<?> getByUsername(@RequestParam String  username)
    {
        var dataResult = this.individualUserService.getByUsername(username);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbymailaddress")
    public ResponseEntity<?> getByMailAddress(@RequestParam String  mailAddress)
    {
        var dataResult = this.individualUserService.getByMailAddress(mailAddress);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

}
