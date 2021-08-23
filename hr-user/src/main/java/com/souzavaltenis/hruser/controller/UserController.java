package com.souzavaltenis.hruser.controller;

import com.souzavaltenis.hruser.model.User;
import com.souzavaltenis.hruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
