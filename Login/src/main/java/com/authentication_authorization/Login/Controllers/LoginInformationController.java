package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.LoginInformation;
import com.authentication_authorization.Login.Repositories.LoginInformationRepo;
import com.authentication_authorization.Login.RequestObjects.LoginRequest;
import com.authentication_authorization.Login.Utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class LoginInformationController {

    @Autowired
    LoginInformationRepo repo;

    @Autowired
    private LoginInformationRepo loginInformationRepo;

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

    @PostMapping("/check_UN_PW")
    public ResponseEntity<List<String>> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Optional<LoginInformation> loginInfoOptional = loginInformationRepo.findByUsername(loginRequest.getUsername());

        if (loginInfoOptional.isPresent()) {
            LoginInformation loginInformation = loginInfoOptional.get();
//            String salt = loginInformation.getSalt();
//            String hashedPassword = PasswordUtils.generatePasswordHash(loginRequest.getPassword(), salt);

//            if (hashedPassword.equals(loginInformation.getPassword())) {
//                return ResponseEntity.ok(List.of("admin options", "Lab reports", "appointments"));
//            }
            //without hashing authentication
            if (loginRequest.getPassword().equals(loginInformation.getPassword())) {

                String role = loginInformation.getRole();

                //Authorization
                if(Objects.equals(role, "admin")){
                    return ResponseEntity.ok(List.of("admin options", "Lab reports", "appointments", "Schedule"));
                }
                if(Objects.equals(role, "doctor")){
                    return ResponseEntity.ok(List.of("Lab reports", "appointments", "Schedule"));
                }
                if(Objects.equals(role, "patient")){
                    return ResponseEntity.ok(List.of("Lab reports", "appointments", "Schedule"));
                }
                if(Objects.equals(role, "lab_assistant")){
                    return ResponseEntity.ok(List.of("Lab reports"));
                }
            }
        }
        return ResponseEntity.ok(Collections.emptyList());
    }






}
