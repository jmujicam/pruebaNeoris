package com.neoris.controller;

import com.neoris.servicios.MovimientoService;
import com.neoris.servicios.dto.GetMovimientoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reporte")
@RequiredArgsConstructor
public class ReporteController {
    private final MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<GetMovimientoDto>> getMovimiento(
            @RequestParam(name = "fechaInicio", required = true) LocalDateTime fechaInicio,
            @RequestParam(name = "fechaFin", required = true) LocalDateTime fechaFin,
            @RequestParam(name = "clienteId", required = true) UUID clienteId
    ){
        return  ResponseEntity.ok(movimientoService.obtenerMovimientoClienteFecha(
                fechaInicio,fechaFin,clienteId
        ));
    }
}
