package com.tp_3055.system.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tp_3055.system.model.User;

public interface UserRepositry extends JpaRepository <User , Long>{
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
    
}
