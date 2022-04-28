package com.scpg.gamelibrary.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.scpg.gamelibrary.entities.abstracts.IEntity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "games")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Game implements IEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String publisherUsername;
    private String name;
    private double price;
    private int ageLimit;
}
