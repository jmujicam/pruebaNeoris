package com.neoris.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.neoris.entity.enumerados.TipoMovimiento;

import jakarta.persistence.*;
import lombok.*;

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
