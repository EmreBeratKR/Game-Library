package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.entities.concretes.Game;

import java.util.List;

public interface IGameService
{
    List<Game> getAll();
}
