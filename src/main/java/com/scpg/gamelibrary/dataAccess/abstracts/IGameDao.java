package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGameDao extends JpaRepository<Game, Integer>
{
    List<Game> getAllByPublisherId(int publisherId);
    List<Game> getAllByName(String name);
    List<Game> getAllByNameContains(String input);
}
