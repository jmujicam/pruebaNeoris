package com.neoris.cliente.entity;

import com.neoris.cliente.entity.enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private LocalDateTime fecha;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    @NonNull
    private float valor;

    @NonNull
    private float saldo;

    @ManyToOne
    @JoinColumn(name = "cuentaId", nullable = false)
    private Cuenta cuenta;
}
