package com.authentication_authorization.Login.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "UserAccounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private long id;

    private String name;
    private String emailAddress;
}
