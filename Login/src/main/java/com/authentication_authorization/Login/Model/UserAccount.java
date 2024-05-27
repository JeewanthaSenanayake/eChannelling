package com.authentication_authorization.Login.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Entity
@Table(name = "UserAccounts")
public class UserAccount {

    @jakarta.persistence.Id
    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )

    private long id;
    private String name;
    private String emailAddress;

}
