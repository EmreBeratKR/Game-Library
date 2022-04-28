package com.scpg.gamelibrary.entities.concretes;

import com.scpg.gamelibrary.entities.abstracts.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "individualUsers")
public class IndividualUser extends User
{
    private int age;
}
