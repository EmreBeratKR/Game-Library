package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IGameService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.ErrorResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
import com.scpg.gamelibrary.dataAccess.abstracts.ICompanyUserDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IGameDao;
import com.scpg.gamelibrary.entities.concretes.CompanyUser;
import com.scpg.gamelibrary.entities.concretes.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameManager implements IGameService
{
    private static final double MinGamePrice = 0.0;
    private static final double MaxGamePrice = 500.0;

    private final ICompanyUserDao companyUserDao;
    private final IGameDao gameDao;


    @Override
    public DataResult<Game> add(Game game)
    {
        var gamePrice = game.getPrice();
        if (gamePrice < MinGamePrice)
        {
            var errorMsg = ErrorMessage.TooLowGamePrice(MinGamePrice);
            return new ErrorDataResult<>(null, errorMsg);
        }
        if (gamePrice > MaxGamePrice)
        {
            var errorMsg = ErrorMessage.TooHighGamePrice(MaxGamePrice);
            return new ErrorDataResult<>(null, errorMsg);
        }

        if (!this.companyUserDao.existsById(game.getPublisherId()))
        {
            var errorMsg = ErrorMessage.PublisherDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        this.gameDao.save(game);
        var successMsg = SuccessMessage.GameAdded;
        return new SuccessDataResult<>(game, successMsg);
    }

    @Override
    public Result remove(Game game)
    {
        if (game == null)
        {
            var errorMsg = ErrorMessage.GameDoesNotExist;
            return new ErrorResult(errorMsg);
        }

        this.gameDao.delete(game);
        var successMsg = SuccessMessage.GameRemoved;
        return new SuccessResult(successMsg);
    }

    @Override
    public DataResult<Game> getById(int id)
    {
        if (!this.gameDao.existsById(id))
        {
            var errorMsg = ErrorMessage.GameDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var game = this.gameDao.getReferenceById(id);
        var successMsg = SuccessMessage.GameFound;
        return new SuccessDataResult<>(game, successMsg);
    }

    @Override
    public DataResult<List<Game>> getAll()
    {
        var games = this.gameDao.findAll();

        if (games.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroGame;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successMsg = SuccessMessage.GamesListed;
        return new SuccessDataResult<>(games, successMsg);
    }

    @Override
    public DataResult<List<Game>> getAllByPublisherId(int publisherId)
    {
        var games = this.gameDao.getAllByPublisherId(publisherId);

        if (games.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroGame;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successMsg = SuccessMessage.GamesListed;
        return new SuccessDataResult<>(games, successMsg);
    }

    @Override
    public DataResult<List<Game>> getAllByNameContains(String input)
    {
        var games = this.gameDao.getAllByNameContains(input);

        if (games.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroGame;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successMsg = SuccessMessage.GamesListed;
        return new SuccessDataResult<>(games, successMsg);
    }
}
