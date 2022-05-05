package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;

import java.util.List;

public interface IUserService<T>
{
    DataResult<T> add(T user);
    Result remove(T user);

    boolean isValidUsername(String username);
    boolean isValidMailAddress(String mailAddress);

    DataResult<List<T>> getAll();
    DataResult<T> getByUserId(int id);
    DataResult<T> getByUsername(String username);
    DataResult<T> getByMailAddress(String mailAddress);
}
