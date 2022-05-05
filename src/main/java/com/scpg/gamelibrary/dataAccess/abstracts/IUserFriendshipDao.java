package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.UserFriendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserFriendshipDao extends JpaRepository<UserFriendship, Integer>
{
    List<UserFriendship> getAllByFirstUserId(int firstUserId);
    List<UserFriendship> getAllBySecondUserId(int secondUserId);
}
