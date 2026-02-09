package com.neoris.controller;

import com.neoris.entity.Cuenta;
import com.neoris.servicios.CuentaService;
import com.neoris.servicios.dto.GetCuentaDto;
import com.neoris.servicios.dto.PostCuentaDto;
import com.neoris.servicios.dto.PutCuentaDto;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cuentas")
@RequiredArgsConstructor
public class CuentaController {
    private final CuentaService cuentaService;

    @GetMapping("/{id}")
    public ResponseEntity<GetCuentaDto> getCuentaId(@PathVariable UUID id) {
        return ResponseEntity.ok(cuentaService.obtenerCuentaId(id));
    }

    @PostMapping
    public ResponseEntity<Void> postCuenta(@Valid @RequestBody PostCuentaDto postCuentaDto) {
        cuentaService.agregarCuenta(postCuentaDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCuenta(@PathVariable UUID id, @RequestBody PutCuentaDto putCuentaDto) {
        cuentaService.actualizarCuenta(putCuentaDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable UUID id) {
        cuentaService.eliminarCuentaId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
