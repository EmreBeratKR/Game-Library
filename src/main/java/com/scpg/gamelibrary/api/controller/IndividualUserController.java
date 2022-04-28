package com.scpg.gamelibrary.api.controller;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/individualUser")
public class IndividualUserController extends UserController<IndividualUser, IIndividualUserService>
{
    public IndividualUserController(IIndividualUserService genericUserService)
    {
        super(genericUserService);
    }
}
