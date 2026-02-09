package com.neoris.repository;

import java.util.List;
import java.util.UUID;

import com.neoris.servicios.dto.GetCuentaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neoris.entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, UUID> {
}
