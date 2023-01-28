package com.tp_3055.system.service;


import com.tp_3055.system.model.Admin;

public interface AdminServices {
    void save(Admin admin);
    Admin getById(Long id);
}
