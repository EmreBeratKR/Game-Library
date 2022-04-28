package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import com.scpg.gamelibrary.entities.concretes.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIndividualUserDao extends JpaRepository<IndividualUser, UserId>
{
    List<IndividualUser> getAllByProfileName(String profileName);
    List<IndividualUser> getAllByAge(int age);

    IndividualUser getByUserIdUsername(String username);
    IndividualUser getByUserIdMailAddress(String mailAddress);

    boolean existsByUserIdUsernameOrUserIdMailAddress(String username, String mailAddress);
}
