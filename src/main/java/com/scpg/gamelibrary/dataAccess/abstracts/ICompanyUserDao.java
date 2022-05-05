package com.scpg.gamelibrary.dataAccess.abstracts;

import com.scpg.gamelibrary.entities.concretes.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyUserDao extends JpaRepository<CompanyUser, Integer>
{
    CompanyUser getByUsername(String username);
    CompanyUser getByMailAddress(String mailAddress);

    boolean existsByUsername(String username);
    boolean existsByMailAddress(String mailAddress);
}
