package com.neoris.cliente.client;

import com.neoris.cliente.service.dto.GetMovimientoDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ClienteWebReporte {

    List<GetMovimientoDto> getMovemimientos(LocalDateTime fromDate, LocalDateTime toDate, UUID customerId);
}
