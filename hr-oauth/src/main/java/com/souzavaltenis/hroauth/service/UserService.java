package com.souzavaltenis.hroauth.service;

import com.souzavaltenis.hroauth.feignclient.UserFeignClient;
import com.souzavaltenis.hroauth.model.User;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        ResponseEntity<User> userResponseEntity = userFeignClient.findByEmail(email);
        return userResponseEntity.getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            ResponseEntity<User> userResponseEntity = userFeignClient.findByEmail(username);
            user = userResponseEntity.getBody();
        } catch (FeignException e) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }
}
