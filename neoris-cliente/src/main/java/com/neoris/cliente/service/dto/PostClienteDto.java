package com.neoris.cliente.service.dto;

import com.neoris.cliente.entity.enums.Estado;
import com.neoris.cliente.entity.enums.Genero;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostClienteDto {
    private UUID id;

    private String nombre;

    @NotNull(message = "La identificacion no puede ser nula")
    @Pattern(regexp = "^[0-9]+$", message = "Identificacion Invalida")
    @Size(min = 10, max = 13, message = "Identificacion Invalida")
    private String identificacion;

    @NotNull(message = "La direccion no puede ser nula")
    private String direccion;

    @NotNull(message = "El telefono no puede ser nulo")
    @Pattern(regexp = "^[0-9]+$", message = "Telefono Invalido")
    private String telefono;

    @NotNull(message = "El genero no puede ser nulo")
    private Genero genero;

    @NotNull(message = "La contraseña no puede ser nula")
    private String contrasenia;

    @NotNull(message = "El estado no puede ser nulo")
    private Estado estado;

    @NotNull(message = "La edad no puede ser nula")
    private int edad;

}
