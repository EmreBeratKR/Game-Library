package com.scpg.gamelibrary.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.scpg.gamelibrary.entities.concretes.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public abstract class User implements IEntitity, Serializable
{
    @EmbeddedId
    private UserId userId;
    private String profileName;
    private String password;
}
