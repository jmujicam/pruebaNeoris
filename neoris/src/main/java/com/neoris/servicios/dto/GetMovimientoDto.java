package com.neoris.servicios.dto;

import com.neoris.entity.enumerados.Estado;
import com.neoris.entity.enumerados.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
