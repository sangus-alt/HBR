// src/main/java/com/hbr/repository/ClientRepository.java
package com.hbr.repository;

import com.hbr.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
