package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.entities.concretes.Game;
import com.scpg.gamelibrary.entities.concretes.GameOwnership;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;

import java.util.List;

public interface IGameOwnershipService
{
    DataResult<GameOwnership> add(GameOwnership gameOwnership);
    Result remove(GameOwnership gameOwnership);

    DataResult<GameOwnership> getById(int id);

    DataResult<List<Game>> getOwnedGames(IndividualUser user);
    DataResult<List<IndividualUser>> getGameOwners(Game game);
}
