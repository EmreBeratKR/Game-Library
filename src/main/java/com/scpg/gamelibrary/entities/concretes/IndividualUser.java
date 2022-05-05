package com.scpg.gamelibrary.entities.concretes;

import com.scpg.gamelibrary.entities.abstracts.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "individualUsers")
public class IndividualUser extends User
{
    private int age;

    public IndividualUser(int userId, String username, String mailAddress, String profileName, String password, int age)
    {
        super(userId, username, mailAddress, profileName, password);
        this.age = age;
    }
}
