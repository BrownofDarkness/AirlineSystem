package com.tp_3055.system.service;


import java.util.List;

import com.tp_3055.system.model.User;

public interface UserServices {
    List<User> getAllClients();
    void save(User user);
    User getById(Long id);
    void deleteViaId(Long id);
    
}
