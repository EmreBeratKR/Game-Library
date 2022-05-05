package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIndividualUserDao extends JpaRepository<IndividualUser, Integer>
{
    IndividualUser getByUsername(String username);
    IndividualUser getByMailAddress(String mailAddress);

    boolean existsByUsername(String username);
    boolean existsByMailAddress(String mailAddress);
}
