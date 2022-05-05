package com.scpg.gamelibrary.business.concretes;

import com.scpg.gamelibrary.business.abstracts.IIndividualUserService;
import com.scpg.gamelibrary.business.abstracts.IUserFriendshipService;
import com.scpg.gamelibrary.core.Message.ErrorMessage;
import com.scpg.gamelibrary.core.Message.SuccessMessage;
import com.scpg.gamelibrary.core.result.abstracts.DataResult;
import com.scpg.gamelibrary.core.result.abstracts.Result;
import com.scpg.gamelibrary.core.result.concretes.ErrorDataResult;
import com.scpg.gamelibrary.core.result.concretes.ErrorResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessDataResult;
import com.scpg.gamelibrary.core.result.concretes.SuccessResult;
import com.scpg.gamelibrary.dataAccess.abstracts.IIndividualUserDao;
import com.scpg.gamelibrary.dataAccess.abstracts.IUserFriendshipDao;
import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import com.scpg.gamelibrary.entities.concretes.UserFriendship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFriendshipManager implements IUserFriendshipService
{
    private final IUserFriendshipDao userFriendshipDao;
    private final IIndividualUserDao individualUserDao;


    @Override
    public DataResult<UserFriendship> add(UserFriendship userFriendship)
    {
        var firstUserId = userFriendship.getFirstUserId();
        var secondUserId = userFriendship.getSecondUserId();

        if (firstUserId == secondUserId)
        {
            var errorMsg = ErrorMessage.InvalidFriendship_Self;
            return new ErrorDataResult<>(null, errorMsg);
        }

        if (!this.individualUserDao.existsById(firstUserId))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        if (!this.individualUserDao.existsById(secondUserId))
        {
            var errorMsg = ErrorMessage.UserDoesNotExist;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var normalUserFriendships = this.userFriendshipDao.getAllByFirstUserId(firstUserId);

        for (var normalUserFriendship : normalUserFriendships)
        {
            if (normalUserFriendship.getSecondUserId() == secondUserId)
            {
                var errorMsg = ErrorMessage.FriendshipAlreadyExists;
                return new ErrorDataResult<>(null, errorMsg);
            }
        }

        var reverseUserFriendships = this.userFriendshipDao.getAllBySecondUserId(firstUserId);

        for (var reverseUserFriendship : reverseUserFriendships)
        {
            if (reverseUserFriendship.getFirstUserId() == secondUserId)
            {
                var errorMsg = ErrorMessage.FriendshipAlreadyExists;
                return new ErrorDataResult<>(null, errorMsg);
            }
        }

        this.userFriendshipDao.save(userFriendship);
        var successMsg = SuccessMessage.FriendshipAdded;
        return new SuccessDataResult<>(userFriendship, successMsg);
    }

    @Override
    public Result remove(UserFriendship userFriendship)
    {
        if (userFriendship == null)
        {
            var errorMsg = ErrorMessage.FriendshipDoesNotExist;
            return new ErrorResult(errorMsg);
        }

        var firstUserId = userFriendship.getFirstUserId();
        var secondUserId = userFriendship.getSecondUserId();

        var normalUserFriendships = this.userFriendshipDao.getAllByFirstUserId(firstUserId);

        for (var normalUserFriendship : normalUserFriendships)
        {
            if (normalUserFriendship.getSecondUserId() == secondUserId)
            {
                this.userFriendshipDao.delete(normalUserFriendship);
                var successMsg = SuccessMessage.FriendshipRemoved;
                return new SuccessResult(successMsg);
            }
        }

        var reverseUserFriendhips = this.userFriendshipDao.getAllBySecondUserId(firstUserId);

        for (var reverseUserFriendhip : reverseUserFriendhips)
        {
            if (reverseUserFriendhip.getFirstUserId() == secondUserId)
            {
                this.userFriendshipDao.delete(reverseUserFriendhip);
                var successMsg = SuccessMessage.FriendshipRemoved;
                return new SuccessResult(successMsg);
            }
        }

        var errorMsg = ErrorMessage.FriendshipDoesNotExist;
        return new ErrorDataResult<>(errorMsg);
    }

    @Override
    public DataResult<UserFriendship> getById(int id)
    {
        if (this.userFriendshipDao.existsById(id))
        {
            var userFriendship = this.userFriendshipDao.getReferenceById(id);
            var successMsg = SuccessMessage.FriendshipFound;
            return new SuccessDataResult<>(userFriendship, successMsg);
        }

        var errorMsg = ErrorMessage.FriendshipDoesNotExist;
        return new ErrorDataResult<>(null, errorMsg);
    }

    @Override
    public DataResult<List<IndividualUser>> getAllFriends(IndividualUser user)
    {
        var userId = user.getUserId();

        var normalFriendships = this.userFriendshipDao.getAllByFirstUserId(userId);
        var reverseFriendships = this.userFriendshipDao.getAllBySecondUserId(userId);

        List<IndividualUser> friends = new ArrayList<>();

        for (var normalFriendship : normalFriendships)
        {
            var friend = this.individualUserDao.getReferenceById(normalFriendship.getSecondUserId());
            friends.add(friend);
        }

        for (var reverseFriendship : reverseFriendships)
        {
            var friend = this.individualUserDao.getReferenceById(reverseFriendship.getFirstUserId());
            friends.add(friend);
        }

        if (friends.isEmpty())
        {
            var errorMsg = ErrorMessage.ZeroUser;
            return new ErrorDataResult<>(null, errorMsg);
        }

        var successMsg = SuccessMessage.UsersListed;
        return new SuccessDataResult<>(friends, successMsg);
    }
}
