package com.neoris.cliente.service.dto;

import com.neoris.cliente.entity.enums.Estado;
import com.neoris.cliente.entity.enums.Genero;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetClienteDto {
    private UUID clienteId;
    private  String nombre;
    private  String identificacion;
    private  String direccion;
    private  String telefono;
    private Genero genero;
    private Estado estado;
    private  String contrasenia;

}
