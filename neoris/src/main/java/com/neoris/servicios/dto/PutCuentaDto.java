package com.neoris.servicios.dto;

import com.neoris.entity.enumerados.Estado;
import com.neoris.entity.enumerados.TipoCuenta;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PutCuentaDto {
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private float saldoInicial;
    private float balance;
    private Estado estado;
}
