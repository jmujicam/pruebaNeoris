package com.neoris.servicios.dto;

import com.neoris.entity.enumerados.Estado;
import com.neoris.entity.enumerados.TipoCuenta;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCuentaDto {
    private UUID id;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private float saldoInicial;
    private float balance;
    private Estado estado;
}
