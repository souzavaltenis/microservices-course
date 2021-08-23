package com.souzavaltenis.hroauth.service;

import com.souzavaltenis.hroauth.feignclient.UserFeignClient;
import com.souzavaltenis.hroauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        ResponseEntity<User> userResponseEntity = userFeignClient.findByEmail(email);
        return userResponseEntity.getBody();
    }
}
