package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameDao extends JpaRepository<Game, Integer>
{
    
}
