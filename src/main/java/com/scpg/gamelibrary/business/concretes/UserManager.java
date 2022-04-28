package com.scpg.gamelibrary.business.concretes;


import com.scpg.gamelibrary.business.abstracts.IUserService;
import com.scpg.gamelibrary.dataAccess.abstracts.IUserDao;
import com.scpg.gamelibrary.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements IUserService
{
    private final IUserDao userDao;


    @Override
    public User add(User user)
    {
        return this.userDao.save(user);
    }

    @Override
    public void remove(User user)
    {
        this.userDao.delete(user);
    }

    @Override
    public List<User> getAll()
    {
        return this.userDao.findAll();
    }

    @Override
    public User getById(int id)
    {
        return this.userDao.getReferenceById(id);
    }

    @Override
    public User getByUsername(String username)
    {
        return this.userDao.getByUsername(username);
    }
}
