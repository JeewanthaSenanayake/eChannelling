package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.UserAccount;
import com.authentication_authorization.Login.Repositories.UserAccountRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;
import java.util.Optional;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountRepo repo;

    @PostMapping("/addUser")
    public ResponseEntity<String> adduser(@RequestBody UserAccount user){

        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be null or empty");
        }
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Email address cannot be null or empty");
        }

        repo.save(user);
        return ResponseEntity.ok("User Added Successfully");
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserAccount> getUser(@PathVariable long id){
        Optional<UserAccount> user = repo.findById(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

}
