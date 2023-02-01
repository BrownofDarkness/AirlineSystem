package com.tp_3055.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tp_3055.system.model.CustomUserDetails;
import com.tp_3055.system.model.User;
import com.tp_3055.system.repos.UserRepositry;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepositry userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
 
}