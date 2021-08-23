package com.souzavaltenis.hroauth.controller;

import com.souzavaltenis.hroauth.model.User;
import com.souzavaltenis.hroauth.service.UserService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        }catch (FeignException e){
            HttpStatus httpStatus = HttpStatus.valueOf(e.status());
            return ResponseEntity.status(httpStatus).build();
        }
    }
}
