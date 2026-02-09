package com.neoris.servicios.Impl;

import com.neoris.entity.Cliente;
import com.neoris.entity.Cuenta;
import com.neoris.entity.Movimiento;
import com.neoris.entity.enumerados.TipoMovimiento;
import com.neoris.excepciones.BadRequestException;
import com.neoris.excepciones.NotFoundException;
import com.neoris.repository.CuentaRepository;
import com.neoris.repository.MovimientoRepository;
import com.neoris.repository.ClienteRepository;
import com.neoris.servicios.MovimientoService;
import com.neoris.servicios.dto.GetMovimientoDto;
import com.neoris.servicios.dto.PostMovimientoDto;
import com.neoris.servicios.dto.PutMovimientoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovimientoImpl implements MovimientoService {

    private final MovimientoRepository repositorioMovimiento;
    private final CuentaRepository repositorioCuenta;
    private final ClienteRepository repositorioCliente;


    @Override
    public void agregarMovimiento(PostMovimientoDto postMovimientoDto) {
        Optional<Cuenta> findCuenta = repositorioCuenta.findById(postMovimientoDto.getCuentaId());
        if(findCuenta.isEmpty()) {
            throw new NotFoundException("Cuenta No Encontrada: " + postMovimientoDto.getCuentaId());
        }

        Cuenta cuenta = findCuenta.get();

        if(postMovimientoDto.getTipoMovimiento().equals(TipoMovimiento.Ingreso) && postMovimientoDto.getValor()< 0){
            throw new BadRequestException("Movimiento Negativo no Permitido");
        }

        if(postMovimientoDto.getTipoMovimiento().equals(TipoMovimiento.Egreso) && cuenta.getSaldoInicial() < postMovimientoDto.getValor()){
            throw new BadRequestException("Saldo Insuficiente o No disponible");
        }

        Movimiento movimiento = new Movimiento();

        if(postMovimientoDto.getTipoMovimiento().equals(TipoMovimiento.Egreso) ){
            cuenta.setBalance(cuenta.getSaldoInicial() - postMovimientoDto.getValor());
        }
        else {
            cuenta.setBalance(cuenta.getSaldoInicial() + postMovimientoDto.getValor());
        }
        movimiento.setTipoMovimiento(postMovimientoDto.getTipoMovimiento());
        movimiento.setFecha(postMovimientoDto.getFecha());
        movimiento.setValor(postMovimientoDto.getValor());
        movimiento.setSaldo(cuenta.getBalance());
        movimiento.setCuenta(cuenta);

        repositorioMovimiento.save(movimiento);
    }

    @Override
    public GetMovimientoDto obtenerMovimientoId(UUID id) {
        Optional<Movimiento> findMovimiento = repositorioMovimiento.findById(id);
        if(findMovimiento.isEmpty()) {
            throw new NotFoundException("Movimiento No Encontrado: " + id);
        }
        Movimiento movimiento = findMovimiento.get();
        GetMovimientoDto movimientoDto = new GetMovimientoDto();

        movimientoDto.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
        movimientoDto.setSaldoInicial(movimiento.getSaldo());
        movimientoDto.setTipoCuenta(movimiento.getCuenta().getTipoCuenta());
        movimientoDto.setSaldoDisponible(movimiento.getSaldo());
        movimientoDto.setFecha(movimiento.getFecha());

        return  movimientoDto;
    }

    @Override
    public List<GetMovimientoDto> obtenerMovimientoClienteFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin, UUID clienteId) {
        Optional<Cliente> findCliente = repositorioCliente.findById(clienteId);
        if(findCliente.isEmpty()) {
            throw new NotFoundException("Cliente No Encontrado: " + clienteId);
        }

        List<GetMovimientoDto> getMovimientoDtos = repositorioMovimiento.BuscarMovimientosCliente(
                fechaInicio,
                fechaFin,
                clienteId
        );

        if (getMovimientoDtos.isEmpty()){
            throw new NotFoundException("No posee movimiento el cliente: " + clienteId);
        }

        return getMovimientoDtos;
    }

    @Override
    public void eliminarMovimientoId(UUID id) {
        Optional<Movimiento> findMovimiento = repositorioMovimiento.findById(id);
        if(findMovimiento.isEmpty()) {
            throw new NotFoundException("Movimiento No Encontrado: " + id);
        }

        Movimiento movimiento = findMovimiento.get();
        repositorioMovimiento.delete(movimiento);
    }

}
