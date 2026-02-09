package com.neoris.cliente.service.dto;

import com.neoris.cliente.entity.enums.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMovimientoDto {

    private LocalDateTime fecha;
    private String cliente;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private float saldoInicial;
    private float saldoDisponible;
}
