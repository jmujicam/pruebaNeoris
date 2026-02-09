package com.neoris.servicios;

import com.neoris.servicios.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MovimientoService {
    void agregarMovimiento(PostMovimientoDto postMovimientoDto);
    GetMovimientoDto obtenerMovimientoId(UUID id);
    //void actualizarMovimiento(PutMovimientoDto putMovimientoDto, UUID id);
    void eliminarMovimientoId(UUID id);
    List<GetMovimientoDto> obtenerMovimientoClienteFecha(
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin,
            UUID cliente
    );
}
