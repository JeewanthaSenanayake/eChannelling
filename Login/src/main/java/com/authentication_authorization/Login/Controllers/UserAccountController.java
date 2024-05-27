package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.UserAccount;
import com.authentication_authorization.Login.Repositories.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountRepo repo;

    @PostMapping("/addUser")
    public void adduser(@RequestBody UserAccount user){

        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be null or empty");
        }
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Email address cannot be null or empty");
        }

        repo.save(user);
    }

}
