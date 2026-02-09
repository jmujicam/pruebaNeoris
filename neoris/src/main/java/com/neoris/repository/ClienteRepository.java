package com.neoris.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
