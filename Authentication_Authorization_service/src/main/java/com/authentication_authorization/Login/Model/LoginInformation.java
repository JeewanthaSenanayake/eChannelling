package com.authentication_authorization.Login.Model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LoginInformation")
public class LoginInformation {

    @Id
    private UUID id;

    private String username;
    private String password; 
    private String role;

    @OneToOne
    @JoinColumn(name = "id") // Name of the foreign key column that references UserAccount's primary key
    private UserAccount userAccount;

}