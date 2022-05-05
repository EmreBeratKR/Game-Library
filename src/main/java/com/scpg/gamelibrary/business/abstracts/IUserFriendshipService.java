package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import com.scpg.gamelibrary.entities.concretes.UserFriendship;

import java.util.List;

public interface IUserFriendshipService
{
    DataResult<UserFriendship> add(UserFriendship userFriendship);
    Result remove(UserFriendship userFriendship);

    DataResult<UserFriendship> getById(int id);

    DataResult<List<IndividualUser>> getAllFriends(IndividualUser user);
}
