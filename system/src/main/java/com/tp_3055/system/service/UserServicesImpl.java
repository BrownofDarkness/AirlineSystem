package com.tp_3055.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp_3055.system.model.User;
import com.tp_3055.system.repos.UserRepositry;

public class UserServicesImpl implements UserServices {
    
    @Autowired 
    private UserRepositry userRepo;

    @Override
    public List<User> getAllClients()
    {
        return userRepo.findAll();
    }

    @Override 
    public void save(User user)
    {
        userRepo.save(user);
    }
 
    @Override 
    public User getById(Long id)
    {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                "client not found for id : " + id);
        return user;
    }
 
    @Override 
    public void deleteViaId(Long id)
    {
        userRepo.deleteById(id);
    }
    
}
