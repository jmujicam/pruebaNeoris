package com.neoris.entity;

import java.util.Set;
import java.util.UUID;

import ch.qos.logback.core.net.server.Client;
import com.neoris.entity.enumerados.Estado;
import com.neoris.entity.enumerados.TipoCuenta;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cuentas")
public class Cuenta {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NonNull
	private String numeroCuenta;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private TipoCuenta tipoCuenta;
	
	@NonNull
	private float saldoInicial;

	@NonNull
	private float balance;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "clienteId", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Movimiento> movimientos;
}
