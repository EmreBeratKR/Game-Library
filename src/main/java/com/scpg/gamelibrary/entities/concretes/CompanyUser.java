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
@Table(name = "companyUsers")
public class CompanyUser extends User
{
    private String billAddress;


    public CompanyUser(int userId, String username, String mailAddress, String profileName, String password, String billAddress)
    {
        super(userId, username, mailAddress, profileName, password);
        this.billAddress = billAddress;
    }
}
