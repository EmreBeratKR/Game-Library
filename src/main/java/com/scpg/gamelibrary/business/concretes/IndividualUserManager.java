package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.dataAccess.abstracts.IIndividualUserDao;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndividualUserManager implements IIndividualUserService
{
    private final IIndividualUserDao individualUserDao;

    @Override
    public List<IndividualUser> getAll()
    {
        return this.individualUserDao.findAll();
    }
}
