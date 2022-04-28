package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.entities.concretes.User;

import java.util.List;

public interface IUserService
{
    User add(User user);
    void remove(User user);

    List<User> getAll();
    User getById(int id);
    User getByUsername(String username);
}
