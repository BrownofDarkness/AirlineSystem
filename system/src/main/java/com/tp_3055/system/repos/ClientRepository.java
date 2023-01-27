package com.tp_3055.system.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tp_3055.model.Client;

public interface ClientRepository extends JpaRepository <Client , Long>{
    
}
