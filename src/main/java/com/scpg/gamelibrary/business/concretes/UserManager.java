package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IUserService;
import com.scpg.gamelibrary.dataAccess.abstracts.IUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class UserManager<T, DAO extends IUserDao<T>> implements IUserService<T>
{
    protected final DAO genericUserDao;

    @Override
    public List<T> getAll()
    {
        return genericUserDao.findAll();
    }
}
