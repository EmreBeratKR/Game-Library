package com.scpg.gamelibrary.business.abstracts;

import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.entities.concretes.Game;
import com.scpg.gamelibrary.entities.concretes.Review;

import java.util.List;

public interface IReviewService
{
    DataResult<Review> add(Review review);
    Result remove(Review review);

    DataResult<Review> getById(int id);

    DataResult<List<Review>> getAllGameReviews(Game game);
}
