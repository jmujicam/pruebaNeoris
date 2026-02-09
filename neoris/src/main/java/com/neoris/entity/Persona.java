package com.neoris.entity;

import java.util.UUID;

import com.neoris.entity.enumerados.Genero;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NonNull
	private String nombre;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@NonNull
	private int edad;
	
	@NonNull
	private String identificacion;
	
	@NonNull
	private String direccion;
	
	@NonNull
	private String telefono;
}
