package com.authentication_authorization.Login.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LoginInformation")
public class LoginInformation {


    @Id
    private long id;

    private String username;
    private String password; // Store the hashed password
    private String salt;
    private String role;

    @OneToOne
    @JoinColumn(name = "id") // Name of the foreign key column that references UserAccount's primary key
    private UserAccount userAccount;

}