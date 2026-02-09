package com.neoris.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.neoris.servicios.dto.GetMovimientoDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neoris.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;

public interface MovimientoRepository extends JpaRepository<Movimiento, UUID>{
    @Query("SELECT new com.neoris.servicios.dto.GetMovimientoDto(m.fecha, c.nombre, a.numeroCuenta, a.tipoCuenta, a.saldoInicial, m.saldo) " +
            "FROM clientes c " +
            "JOIN c.cuentas a " +
            "JOIN a.movimientos m " +
            "WHERE c.id = :clienteId " +
            "AND m.fecha >= :fechaInicio " +
            "AND m.fecha <= :fechaFin " +
            "ORDER BY m.fecha DESC")
    List<GetMovimientoDto> BuscarMovimientosCliente(LocalDateTime fechaInicio, LocalDateTime fechaFin, UUID clienteId);
}
