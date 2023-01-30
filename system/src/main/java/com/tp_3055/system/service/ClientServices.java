package com.tp_3055.system.service;


import java.util.List;

import com.tp_3055.system.model.Client;

public interface ClientServices {
    List<Client> getAllClients();
    void save(Client client);
    Client getById(Long id);
    void deleteViaId(Long id);
    
}
