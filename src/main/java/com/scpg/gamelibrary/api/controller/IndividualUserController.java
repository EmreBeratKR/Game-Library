package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import com.scpg.gamelibrary.entities.concretes.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/individualUser")
@RequiredArgsConstructor
public class IndividualUserController
{
    private final IIndividualUserService individualUserService;


    @GetMapping("/register")
    public IndividualUser register(@RequestParam String username,
                                   @RequestParam String mailAddress,
                                   @RequestParam String profileName,
                                   @RequestParam String password,
                                   @RequestParam int age)
    {
        return this.individualUserService.add(new IndividualUser
                (
                   new UserId(username, mailAddress),
                   profileName,
                   password,
                   age
                ));
    }

    @GetMapping("/removebyusername")
    public void removeByUsername(@RequestParam String username)
    {
        this.individualUserService.remove(this.individualUserService.getByUsername(username));
    }

    @GetMapping("/removebymailaddress")
    public void removeByMailAddress(@RequestParam String mailAddress)
    {
        this.individualUserService.remove(this.individualUserService.getByMailAddress(mailAddress));
    }

    @GetMapping("/getall")
    public List<IndividualUser> getAll()
    {
        return this.individualUserService.getAll();
    }

    @GetMapping("/getallbyprofilename")
    public List<IndividualUser> getAllByProfileName(@RequestParam String username)
    {
        return this.individualUserService.getAllByProfileName(username);
    }

    @GetMapping("/getallbyage")
    public List<IndividualUser> getAllByAge(@RequestParam int age)
    {
        return this.individualUserService.getAllByAge(age);
    }

    @GetMapping("/getbyusername")
    public IndividualUser getByUsername(@RequestParam String username)
    {
        return this.individualUserService.getByUsername(username);
    }

    @GetMapping("/getbymailaddress")
    public IndividualUser getByMailAddress(@RequestParam String mailAddress)
    {
        return this.individualUserService.getByMailAddress(mailAddress);
    }
}
