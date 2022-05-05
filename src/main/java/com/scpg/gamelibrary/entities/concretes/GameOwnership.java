package com.scpg.gamelibrary.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.scpg.gamelibrary.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gameOwnerships")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class GameOwnership implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownershipId;
    private int ownerId;
    private int gameId;
}
