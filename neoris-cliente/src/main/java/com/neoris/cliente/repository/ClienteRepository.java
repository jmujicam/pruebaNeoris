package com.neoris.cliente.repository;

import com.neoris.cliente.entity.Cliente;
import com.neoris.cliente.service.dto.GetClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    @Query("SELECT new com.neoris.cliente.service.dto.GetClienteDto(c.id, c.nombre, c.identificacion, c.direccion, c.telefono, c.genero, c.estado, c.contrasenia) " +
            "FROM clientes c ")
    List<GetClienteDto> listadoClientes();
}
