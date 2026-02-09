package com.neoris.servicios.dto;

import com.neoris.entity.enumerados.TipoMovimiento;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PostMovimientoDto {
    private UUID cuentaId;
    private LocalDateTime fecha;
    private TipoMovimiento tipoMovimiento;
    private float valor;

}
