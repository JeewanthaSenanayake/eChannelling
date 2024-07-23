package com.authentication_authorization.Login.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "UserAccounts")
public class UserAccount {

    @Id
    private UUID id;

    private String name;
    private String nicNumber;
    private String emailAddress;
}
