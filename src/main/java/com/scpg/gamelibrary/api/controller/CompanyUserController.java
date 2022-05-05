package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.ICompanyUserService;
import com.scpg.gamelibrary.entities.concretes.CompanyUser;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companyusers")
@RequiredArgsConstructor
public class CompanyUserController
{
    private final ICompanyUserService companyUserService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CompanyUser user)
    {
        var dataResult = this.companyUserService.add(user);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/removebyid")
    public ResponseEntity<?> removeById(@RequestParam int id)
    {
        var resultData = this.companyUserService.getByUserId(id);

        var result = this.companyUserService.remove(resultData.getData());

        if (result.isSuccess())
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll()
    {
        var dataResult = this.companyUserService.getAll();

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id)
    {
        var dataResult = this.companyUserService.getByUserId(id);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyusername")
    public ResponseEntity<?> getByUsername(@RequestParam String  username)
    {
        var dataResult = this.companyUserService.getByUsername(username);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbymailaddress")
    public ResponseEntity<?> getByMailAddress(@RequestParam String  mailAddress)
    {
        var dataResult = this.companyUserService.getByMailAddress(mailAddress);

        if (dataResult.isSuccess())
        {
            return new ResponseEntity<>(dataResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(dataResult, HttpStatus.BAD_REQUEST);
    }
}
