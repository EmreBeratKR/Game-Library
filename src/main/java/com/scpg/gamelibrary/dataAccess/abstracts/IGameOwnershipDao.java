package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.GameOwnership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGameOwnershipDao extends JpaRepository<GameOwnership, Integer>
{
    List<GameOwnership> getAllByOwnerId(int ownerId);
    List<GameOwnership> getAllByGameId(int gameId);
}
