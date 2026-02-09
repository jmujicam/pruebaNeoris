package com.neoris.cliente.entity;

import com.neoris.cliente.entity.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clientes")
public class Cliente extends Persona{
    @NonNull
    private String contrasenia;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cuenta> cuentas;
}
