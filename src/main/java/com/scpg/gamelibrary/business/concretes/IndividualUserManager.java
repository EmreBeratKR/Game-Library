package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.ErrorResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
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
    public DataResult<IndividualUser> add(IndividualUser user)
    {
        if (!isValidUsername(user.getUsername()))
        {
            var errorMsg = "Username {" + user.getUsername() + "} is already existing!";
            return new ErrorDataResult<>(null, errorMsg);
        }

        if (!isValidMailAddress(user.getMailAddress()))
        {
            var errorMsg = "Mail Address {" + user.getMailAddress() + "} is already existing!";
            return new ErrorDataResult<>(null, errorMsg);
        }

        this.individualUserDao.save(user);
        var successMsg = "User Successfully added to Database!";
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public Result remove(IndividualUser user)
    {
        if (!this.individualUserDao.existsById(user.getUserId()))
        {
            var errorMsg = "User does not Exist!";
            return new ErrorResult(errorMsg);
        }

        this.individualUserDao.delete(user);
        var successMsg = "User Successfuly removed from Database";
        return new SuccessResult(successMsg);
    }

    @Override
    public boolean isValidUsername(String username)
    {
        return !this.individualUserDao.existsByUsername(username);
    }

    @Override
    public boolean isValidMailAddress(String mailAddress)
    {
        return !this.individualUserDao.existsByMailAddress(mailAddress);
    }

    @Override
    public DataResult<List<IndividualUser>> getAll()
    {
        var users = this.individualUserDao.findAll();

        if (users.isEmpty())
        {
            var errorMsg = "There is no Individual Users to show!";
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successResult = "Individual Users are Successfully Listed!";
        return new SuccessDataResult<>(users, successResult);
    }

    @Override
    public IndividualUser getByUserId(int id)
    {
        return this.individualUserDao.getReferenceById(id);
    }

    @Override
    public IndividualUser getByUsername(String username)
    {
        return this.individualUserDao.getByUsername(username);
    }

    @Override
    public IndividualUser getByMailAddress(String mailAddress)
    {
        return this.individualUserDao.getByMailAddress(mailAddress);
    }
}
