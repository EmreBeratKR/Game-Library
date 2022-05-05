package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.entities.concretes.Game;

import java.util.List;

public interface IGameService
{
    DataResult<Game> add(Game game);
    Result remove(Game game);

    DataResult<Game> getById(int id);
    DataResult<List<Game>> getAll();
    DataResult<List<Game>> getAllByPublisherId(int publisherId);
    DataResult<List<Game>> getAllByNameContains(String input);
}
