package com.scpg.gamelibrary.entities.concretes;

import com.scpg.gamelibrary.entities.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "companyUsers")
public class CompanyUser extends User
{
    private String billAddress;
}
