package com.scpg.gamelibrary.business.abstracts;

import java.util.List;

public interface IUserService<T>
{
    List<T> getAll();
}
