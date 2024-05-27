package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.LoginInformation;
import com.authentication_authorization.Login.Repositories.LoginInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginInformationController {

    @Autowired
    LoginInformationRepo repo;

    @PostMapping("/add_UN_PW")
    public ResponseEntity<String> addLoginInformation(@RequestBody LoginInformation user){

        if(user.getUsername() == null || user.getUsername().isEmpty() ){
            return ResponseEntity.badRequest().body("username cannot be null or empty");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty() ){
            return ResponseEntity.badRequest().body("password cannot be null or empty");
        }
        if(user.getRole() == null || user.getRole().isEmpty() ){
            return ResponseEntity.badRequest().body("role cannot be null or empty");
        }
        //generate salt and add to user.setSalt()

        repo.save(user);
        return ResponseEntity.ok("User Registered successfully");
    }
}
