package com.neoris.cliente.service.dto;

import com.neoris.cliente.entity.enums.Estado;
import com.neoris.cliente.entity.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutClienteDto {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private Genero genero;
    private String contrasenia;
    private Estado estado;
}
