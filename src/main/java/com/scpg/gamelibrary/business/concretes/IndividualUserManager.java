package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
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
        var username = user.getUsername();
        if (!isValidUsername(username))
        {
            var errorMsg = ErrorMessage.UserAlreadyExistByUsername(username);
            return new ErrorDataResult<>(null, errorMsg);
        }

        var mailAddress = user.getMailAddress();
        if (!isValidMailAddress(mailAddress))
        {
            var errorMsg = ErrorMessage.UserAlreadyExistByMailAddress(mailAddress);
            return new ErrorDataResult<>(null, errorMsg);
        }

        this.individualUserDao.save(user);
        var successMsg = SuccessMessage.UserAdded;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public Result remove(IndividualUser user)
    {
        if (user == null)
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorResult(errorMsg);
        }

        this.individualUserDao.delete(user);
        var successMsg = SuccessMessage.UserRemoved;
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
            var errorMsg = ErrorMessage.ZeroUser;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successResult = SuccessMessage.UsersListed;
        return new SuccessDataResult<>(users, successResult);
    }

    @Override
    public DataResult<IndividualUser> getByUserId(int id)
    {
        if (!this.individualUserDao.existsById(id))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.individualUserDao.getReferenceById(id);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public DataResult<IndividualUser> getByUsername(String username)
    {
        if (!this.individualUserDao.existsByUsername(username))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.individualUserDao.getByUsername(username);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public DataResult<IndividualUser> getByMailAddress(String mailAddress)
    {
        if (!this.individualUserDao.existsByMailAddress(mailAddress))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.individualUserDao.getByMailAddress(mailAddress);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }
}
