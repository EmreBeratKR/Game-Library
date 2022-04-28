package com.scpg.gamelibrary.business.abstracts;

import java.util.List;

public interface IUserService<T>
{
    T add(T user);

    List<T> getAll();
    T getByUsername(String username);
    T getByMailAddress(String mailAddress);
}
