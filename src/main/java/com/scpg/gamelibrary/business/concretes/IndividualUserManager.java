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
    public IndividualUser add(IndividualUser user)
    {
        return individualUserDao.save(user);
    }

    @Override
    public List<IndividualUser> getAll()
    {
        return this.individualUserDao.findAll();
    }

    @Override
    public IndividualUser getByUsername(String username)
    {
        return this.individualUserDao.getByUserIdUsername(username);
    }

    @Override
    public IndividualUser getByMailAddress(String mailAddress)
    {
        return this.individualUserDao.getByUserIdMailAddress(mailAddress);
    }
}
