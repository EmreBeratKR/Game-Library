package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.dataAccess.abstracts.IIndividualUserDao;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;

public class IndividualUserManager extends UserManager<IndividualUser, IIndividualUserDao>
{
    public IndividualUserManager(IIndividualUserDao genericUserDao)
    {
        super(genericUserDao);
    }
}
