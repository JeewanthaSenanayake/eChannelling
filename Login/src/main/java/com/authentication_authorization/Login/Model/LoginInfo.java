//package com.authentication_authorization.Login.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
//import jakarta.persistence.Id;
//import lombok.Data;
//
//import java.util.UUID;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Data
//@Entity
//@Table(name = "LoginInfo")
//public class LoginInfo {
//
//    @Id
//    @GeneratedValue(strategy  = GenerationType.AUTO)
////    @GenericGenerator(
////            name = "UUID",
////            strategy = "org.hibernate.id.UUIDGenerator"
////    )
//
//    private long id;
//
//    @NotNull(message = "Name cannot be null")
//    @Size(min = 2, message = "Name must not be empty")
//    private String name;
//
//    @NotNull(message = "Email address cannot be null")
//    @Size(min = 3, message = "Email address must not be empty")
//    private String emailAddress;
//
//}