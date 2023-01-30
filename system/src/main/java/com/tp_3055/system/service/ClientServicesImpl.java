package com.tp_3055.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp_3055.system.model.Client;
import com.tp_3055.system.repos.ClientRepository;

public class ClientServicesImpl implements ClientServices {
    
    @Autowired private ClientRepository clientRepo;

    @Override
    public List<Client> getAllClients()
    {
        return clientRepo.findAll();
    }

    @Override 
    public void save(Client client)
    {
        clientRepo.save(client);
    }
 
    @Override 
    public Client getById(Long id)
    {
        Optional<Client> optional = clientRepo.findById(id);
        Client client = null;
        if (optional.isPresent())
            client = optional.get();
        else
            throw new RuntimeException(
                "client not found for id : " + id);
        return client;
    }
 
    @Override 
    public void deleteViaId(Long id)
    {
        clientRepo.deleteById(id);
    }
    
}
