package com.neoris.cliente.controller;

import com.neoris.cliente.service.ClienteService;
import com.neoris.cliente.service.dto.GetClienteDto;
import com.neoris.cliente.service.dto.PostClienteDto;
import com.neoris.cliente.service.dto.PutClienteDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteControlller {
    @Autowired
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<GetClienteDto>> getCliente() {
        return ResponseEntity.ok(clienteService.getClientesDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClienteDto> getClienteId(@PathVariable UUID id) {
        return ResponseEntity.ok(clienteService.getClienteId(id));
    }

    @PostMapping
    public ResponseEntity<Void> postCliente(@Valid @RequestBody PostClienteDto postClienteDto) {
        clienteService.agregarCliente(postClienteDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCliente(@PathVariable UUID id,@Valid @RequestBody PutClienteDto putClienteDto) {
        clienteService.actualizarCliente(putClienteDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id) {
        clienteService.eliminarClienteId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
