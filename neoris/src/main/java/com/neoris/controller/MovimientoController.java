package com.neoris.controller;

import com.neoris.servicios.MovimientoService;
import com.neoris.servicios.dto.GetMovimientoDto;
import com.neoris.servicios.dto.PostMovimientoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
public class MovimientoController {
    private final MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity postMovimiento(@RequestBody PostMovimientoDto postMovimientoDto){
        movimientoService.agregarMovimiento(postMovimientoDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMovimientoDto> getMovimientoId(@PathVariable UUID id) {
        return ResponseEntity.ok(movimientoService.obtenerMovimientoId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable UUID id) {
        movimientoService.eliminarMovimientoId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
