package com.neoris.cliente.service;

import com.neoris.cliente.entity.Cliente;
import com.neoris.cliente.service.dto.GetClienteDto;
import com.neoris.cliente.service.dto.PostClienteDto;
import com.neoris.cliente.service.dto.PutClienteDto;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    List<GetClienteDto> getClientesDto();
    GetClienteDto getClienteId(UUID id);
    void agregarCliente(PostClienteDto postClienteDto);
    void actualizarCliente(PutClienteDto putClienteDto,UUID id);
    void eliminarClienteId(UUID id);
}
