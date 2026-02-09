package com.neoris.cliente.service.impl;

import com.neoris.cliente.entity.Cliente;
import com.neoris.cliente.exception.NotFoundException;
import com.neoris.cliente.repository.ClienteRepository;
import com.neoris.cliente.service.ClienteService;
import com.neoris.cliente.service.dto.GetClienteDto;
import com.neoris.cliente.service.dto.PostClienteDto;
import com.neoris.cliente.service.dto.PutClienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;


    @Override
    public List<GetClienteDto> getClientesDto() {
        List<GetClienteDto> getMovimientoDtos = clienteRepository.listadoClientes();

        if (getMovimientoDtos.isEmpty()){
            throw new NotFoundException("No se encontro Clientes");
        }
        return getMovimientoDtos;
    }

    @Override
    public GetClienteDto getClienteId(UUID id) {
        Optional<Cliente> findCliente = clienteRepository.findById(id);

        if (findCliente.isEmpty()){
            throw new NotFoundException("Cliente No existe: " + id);
        }
        Cliente cliente = findCliente.get();
        GetClienteDto clienteDto = new GetClienteDto();

        clienteDto.setClienteId(cliente.getId());
        clienteDto.setIdentificacion(cliente.getIdentificacion());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setDireccion(cliente.getDireccion());
        clienteDto.setGenero(cliente.getGenero());
        clienteDto.setEstado(cliente.getEstado());
        clienteDto.setTelefono(cliente.getTelefono());
        clienteDto.setContrasenia(cliente.getContrasenia());

        return  clienteDto;
    }

    @Override
    public void agregarCliente(PostClienteDto postClienteDto) {

        Cliente cliente = new Cliente();

        cliente.setNombre(postClienteDto.getNombre());
        cliente.setIdentificacion(postClienteDto.getIdentificacion());
        cliente.setGenero(postClienteDto.getGenero());
        cliente.setDireccion(postClienteDto.getDireccion());
        cliente.setTelefono(postClienteDto.getTelefono());
        cliente.setContrasenia(postClienteDto.getContrasenia());
        cliente.setEdad(postClienteDto.getEdad());
        cliente.setEstado(postClienteDto.getEstado());
        clienteRepository.save(cliente);

        //agregar el fail
    }

    @Override
    public void actualizarCliente(PutClienteDto putClienteDto, UUID id) {
        Optional<Cliente> findCliente = clienteRepository.findById(id);
        if(findCliente.isEmpty()) {
            throw new NotFoundException("Cliente No Encontrado: " + id);
        }

        Cliente cliente = findCliente.get();

        cliente.setNombre(cliente.getNombre());
        cliente.setIdentificacion(cliente.getIdentificacion());
        cliente.setGenero(cliente.getGenero());
        cliente.setDireccion(cliente.getDireccion());
        cliente.setTelefono(cliente.getTelefono());
        cliente.setContrasenia(cliente.getContrasenia());
        cliente.setEdad(cliente.getEdad());
        clienteRepository.save(cliente);

    }

    @Override
    public void eliminarClienteId(UUID id) {
        Optional<Cliente> findCliente = clienteRepository.findById(id);
        if(findCliente.isEmpty()) {
            throw new NotFoundException("Cliente No Encontrado: " + id);
        }

        Cliente cliente = findCliente.get();
        clienteRepository.delete(cliente);
    }
}
