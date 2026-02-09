package com.neoris.cliente.client.Impl;

import com.neoris.cliente.client.ClienteWebReporte;
import com.neoris.cliente.config.ConfiguracionPropiedades;
import com.neoris.cliente.service.dto.GetMovimientoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClienteWebReporteImpl implements ClienteWebReporte {

    private final ConfiguracionPropiedades configuracionPropiedades;
    private final WebClient webClient;

    @Override
    public List<GetMovimientoDto> getMovemimientos(LocalDateTime fechaInicio, LocalDateTime fechaFin, UUID clienteId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(configuracionPropiedades.getClienteCuentaMovimientosPath())
                        .queryParam("fechaInicio", fechaInicio)
                        .queryParam("fechaFin", fechaFin)
                        .queryParam("clienteId", clienteId)
                        .build())
                .retrieve()
                .bodyToFlux(GetMovimientoDto.class)
                .collectList()
                .block();

    }
}
