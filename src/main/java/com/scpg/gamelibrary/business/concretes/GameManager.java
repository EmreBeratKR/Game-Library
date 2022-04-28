package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IGameService;
import com.scpg.gamelibrary.dataAccess.abstracts.IGameDao;
import com.scpg.gamelibrary.entities.concretes.Game;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameManager implements IGameService
{
    private final IGameDao gameDao;


    @Override
    public List<Game> getAll()
    {
        return this.gameDao.findAll();
    }

}
