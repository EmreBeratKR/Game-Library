package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/individualUser")
@RequiredArgsConstructor
public class IndividualUserController
{
    private final IIndividualUserService individualUserService;


    @GetMapping("/getall")
    public List<IndividualUser> getAll()
    {
        return individualUserService.getAll();
    }
}
