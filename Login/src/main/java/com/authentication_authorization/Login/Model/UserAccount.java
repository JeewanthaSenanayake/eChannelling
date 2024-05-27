package com.authentication_authorization.Login.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name must not be empty")
    private String name;

    @NotNull(message = "Email address cannot be null")
    @Size(min = 3, message = "Email address must not be empty")
    private String emailAddress;

}
