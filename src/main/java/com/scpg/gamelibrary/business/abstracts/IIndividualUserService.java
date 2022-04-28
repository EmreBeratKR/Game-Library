package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.entities.concretes.IndividualUser;

import java.util.List;

public interface IIndividualUserService extends IUserService<IndividualUser>
{
    List<IndividualUser> getAllByAge(int age);
}
