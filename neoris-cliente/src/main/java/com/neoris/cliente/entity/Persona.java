package com.neoris.cliente.entity;

import com.neoris.cliente.entity.enums.Genero;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
