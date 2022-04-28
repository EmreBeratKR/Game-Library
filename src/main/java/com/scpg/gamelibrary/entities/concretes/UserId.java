package com.scpg.gamelibrary.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserId implements Serializable
{
    private String username;
    private String mailAddress;


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return username.equals(userId.username) && mailAddress.equals(userId.mailAddress);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, mailAddress);
    }
}
