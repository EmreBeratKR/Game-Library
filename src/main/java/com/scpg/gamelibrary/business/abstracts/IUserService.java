package com.scpg.gamelibrary.business.abstracts;

import java.util.List;

public interface IUserService<T>
{
    T add(T user);
    void remove(T user);

    List<T> getAll();
    List<T> getAllByProfileName(String profileName);
    T getByUsername(String username);
    T getByMailAddress(String mailAddress);
}
