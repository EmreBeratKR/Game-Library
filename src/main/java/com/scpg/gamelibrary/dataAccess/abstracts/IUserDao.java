package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer>
{
    User getByUsername(String username);
}
