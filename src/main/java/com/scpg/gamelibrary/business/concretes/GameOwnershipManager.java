package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IGameOwnershipService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.ErrorResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
import com.scpg.gamelibrary.dataAccess.abstracts.IGameDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IGameOwnershipDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IIndividualUserDao;
import com.scpg.gamelibrary.entities.concretes.Game;
import com.scpg.gamelibrary.entities.concretes.GameOwnership;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameOwnershipManager implements IGameOwnershipService
{
    private final IGameOwnershipDao gameOwnershipDao;
    private final IIndividualUserDao individualUserDao;
    private final IGameDao gameDao;


    @Override
    public DataResult<GameOwnership> add(GameOwnership gameOwnership)
    {
        var ownerId = gameOwnership.getOwnerId();

        if (!this.individualUserDao.existsById(ownerId))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var gameId = gameOwnership.getGameId();

        if (!this.gameDao.existsById(gameId))
        {
            var errorMsg = ErrorMessage.GameDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        this.gameOwnershipDao.save(gameOwnership);
        var successMsg = SuccessMessage.GameOwnershipAdded;
        return new SuccessDataResult<>(gameOwnership, successMsg);
    }

    @Override
    public Result remove(GameOwnership gameOwnership)
    {
        if (gameOwnership == null)
        {
            var errorMsg = ErrorMessage.GameOwnershipDoesNotExist;
            return new ErrorResult(errorMsg);
        }

        this.gameOwnershipDao.delete(gameOwnership);
        var successMsg = SuccessMessage.GameOwnershipRemoved;
        return new SuccessResult(successMsg);
    }

    @Override
    public DataResult<GameOwnership> getById(int id)
    {
        if (this.gameOwnershipDao.existsById(id))
        {
            var gameOwnership = this.gameOwnershipDao.getReferenceById(id);
            var successMsg = SuccessMessage.GameOwnershipFound;
            return new SuccessDataResult<>(gameOwnership, successMsg);
        }

        var errorMsg = ErrorMessage.GameOwnershipDoesNotExist;
        return new ErrorDataResult<>(null, errorMsg);
    }

    @Override
    public DataResult<List<Game>> getOwnedGames(IndividualUser user)
    {
        var ownerId = user.getUserId();
        var gameOwnerships = this.gameOwnershipDao.getAllByOwnerId(ownerId);

        if (gameOwnerships.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroGameOwned;
            return new ErrorDataResult<>(null, errorMsg);
        }

        List<Game> games = new ArrayList<>();
        for (var gameOwnership : gameOwnerships)
        {
            games.add(this.gameDao.getReferenceById(gameOwnership.getGameId()));
        }

        var successMsg = SuccessMessage.GamesListed;
        return new SuccessDataResult<>(games, successMsg);
    }

    @Override
    public DataResult<List<IndividualUser>> getGameOwners(Game game)
    {
        var gameId = game.getId();
        var gameOwnerships = this.gameOwnershipDao.getAllByGameId(gameId);

        if (gameOwnerships.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroUser;
            return new ErrorDataResult<>(null, errorMsg);
        }

        List<IndividualUser> users = new ArrayList<>();
        for (var gameOwnership : gameOwnerships)
        {
            users.add(this.individualUserDao.getReferenceById(gameOwnership.getOwnerId()));
        }

        var successMsg = SuccessMessage.UsersListed;
        return new SuccessDataResult<>(users, successMsg);
    }
}
