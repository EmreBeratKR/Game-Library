package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.ICompanyUserService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.ErrorResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
import com.scpg.gamelibrary.dataAccess.abstracts.ICompanyUserDao;
import com.scpg.gamelibrary.entities.concretes.CompanyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyUserManager implements ICompanyUserService
{
    private final ICompanyUserDao companyUserDao;


    @Override
    public DataResult<CompanyUser> add(CompanyUser user)
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

        this.companyUserDao.save(user);
        var successMsg = SuccessMessage.UserAdded;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public Result remove(CompanyUser user)
    {
        if (user == null)
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorResult(errorMsg);
        }

        this.companyUserDao.delete(user);
        var successMsg = SuccessMessage.UserRemoved;
        return new SuccessResult(successMsg);
    }

    @Override
    public boolean isValidUsername(String username)
    {
        return !this.companyUserDao.existsByUsername(username);
    }

    @Override
    public boolean isValidMailAddress(String mailAddress)
    {
        return !this.companyUserDao.existsByMailAddress(mailAddress);
    }

    @Override
    public DataResult<List<CompanyUser>> getAll()
    {
        var users = this.companyUserDao.findAll();

        if (users.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroUser;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successResult = SuccessMessage.UsersListed;
        return new SuccessDataResult<>(users, successResult);
    }

    @Override
    public DataResult<CompanyUser> getByUserId(int id)
    {
        if (!this.companyUserDao.existsById(id))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.companyUserDao.getReferenceById(id);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public DataResult<CompanyUser> getByUsername(String username)
    {
        if (!this.companyUserDao.existsByUsername(username))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.companyUserDao.getByUsername(username);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }

    @Override
    public DataResult<CompanyUser> getByMailAddress(String mailAddress)
    {
        if (!this.companyUserDao.existsByMailAddress(mailAddress))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var user = this.companyUserDao.getByMailAddress(mailAddress);
        var successMsg = SuccessMessage.UserFound;
        return new SuccessDataResult<>(user, successMsg);
    }
}
