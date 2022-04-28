package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao<T> extends JpaRepository<T, UserId>
{

}
