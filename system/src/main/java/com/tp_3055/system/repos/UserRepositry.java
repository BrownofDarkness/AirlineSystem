package com.tp_3055.system.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tp_3055.system.model.User;

public interface UserRepositry extends JpaRepository <User , Long>{
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.isAdmin = ?1")
    public List<User> getClients(boolean role);
    
}
