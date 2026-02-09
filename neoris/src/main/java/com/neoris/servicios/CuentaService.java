package com.neoris.servicios;

import com.neoris.servicios.dto.GetCuentaDto;
import com.neoris.servicios.dto.PostCuentaDto;
import com.neoris.servicios.dto.PutCuentaDto;

import java.util.List;
import java.util.UUID;

public interface CuentaService {
    List<GetCuentaDto> listarCuenta();
    GetCuentaDto obtenerCuentaId(UUID id);
    void agregarCuenta(PostCuentaDto postCuentaDto);
    void actualizarCuenta(PutCuentaDto putCuentaDto, UUID id);
    void eliminarCuentaId(UUID id);
}
