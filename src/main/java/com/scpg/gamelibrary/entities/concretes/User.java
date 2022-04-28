package com.scpg.gamelibrary.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.scpg.gamelibrary.entities.abstracts.IEntitity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements IEntitity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
