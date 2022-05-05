package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IReviewService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
import com.scpg.gamelibrary.dataAccess.abstracts.IGameDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IIndividualUserDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IReviewDao;
import com.scpg.gamelibrary.entities.concretes.Game;
import com.scpg.gamelibrary.entities.concretes.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewManager implements IReviewService
{
    private final IIndividualUserDao individualUserDao;
    private final IReviewDao reviewDao;
    private final IGameDao gameDao;


    @Override
    public DataResult<Review> add(Review review)
    {
        var content = review.getContent();

        if (content == null || content.equals(""))
        {
            var errorMsg = ErrorMessage.InvalidReview_EmptyContent;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var senderId = review.getSenderId();

        if (!this.individualUserDao.existsById(senderId))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var relatedGameId = review.getRelatedGameId();

        if (!this.gameDao.existsById(relatedGameId))
        {
            var errorMsg = ErrorMessage.GameDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        this.reviewDao.save(review);
        var successMsg = SuccessMessage.ReviewAdded;
        return new SuccessDataResult<>(review, successMsg);
    }

    @Override
    public Result remove(Review review)
    {
        if (review == null)
        {
            var errorMsg = ErrorMessage.ReviewDoesNotExist;
            return new ErrorDataResult<>(errorMsg);
        }

        this.reviewDao.delete(review);
        var successMsg = SuccessMessage.ReviewRemoved;
        return new SuccessResult(successMsg);
    }

    @Override
    public DataResult<Review> getById(int id)
    {
        if (this.reviewDao.existsById(id))
        {
            var review = this.reviewDao.getReferenceById(id);
            var successMsg = SuccessMessage.ReviewFound;
            return new SuccessDataResult<>(review, successMsg);
        }

        var errorMsg = ErrorMessage.ReviewDoesNotExist;
        return new ErrorDataResult<>(null, errorMsg);
    }

    @Override
    public DataResult<List<Review>> getAllGameReviews(Game game)
    {
        var gameId = game.getId();

        var reviews = this.reviewDao.getAllByRelatedGameId(gameId);

        if (reviews.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroReview;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successMsg = SuccessMessage.ReviewsListed;
        return new SuccessDataResult<>(reviews, successMsg);
    }
}
