package com.neoris.servicios.Impl;

import com.neoris.entity.Cliente;
import com.neoris.entity.Cuenta;
import com.neoris.excepciones.NotFoundException;
import com.neoris.repository.ClienteRepository;
import com.neoris.repository.CuentaRepository;
import com.neoris.servicios.CuentaService;
import com.neoris.servicios.dto.GetCuentaDto;
import com.neoris.servicios.dto.PostCuentaDto;
import com.neoris.servicios.dto.PutCuentaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CuentaImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public List<GetCuentaDto> listarCuenta() {
        return null;
    }

    @Override
    public GetCuentaDto obtenerCuentaId(UUID id) {
        Optional<Cuenta> findCuenta = cuentaRepository.findById(id);

        if (findCuenta.isEmpty()){
            throw new NotFoundException("Cuenta No existe: " + id);
        }
        Cuenta cuenta = findCuenta.get();
        GetCuentaDto cuentaDto = new GetCuentaDto();

        cuentaDto.setId(cuenta.getId());
        cuentaDto.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDto.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaDto.setEstado(cuenta.getEstado());
        cuentaDto.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaDto.setBalance(cuenta.getBalance());

        return  cuentaDto;
    }

    @Override
    public void agregarCuenta(PostCuentaDto postCuentaDto) {
        Optional<Cliente> findCliente = clienteRepository.findById(postCuentaDto.getClienteId());
        if(findCliente.isEmpty()) {
            throw new NotFoundException("Cliente No Encontrado: " + postCuentaDto.getClienteId());
        }
//        Optional<Cuenta> findCuenta = cuentaRepository.findById(postCuentaDto.getId());
//
//        if (findCuenta.isEmpty()){
//            throw new NotFoundException("Cuenta No existe: " + postCuentaDto.getId());
//        }
        Cliente cliente = findCliente.get();

        Cuenta cuenta = new Cuenta();
        //Cuenta cuenta = findCuenta.get();

        cuenta.setNumeroCuenta(postCuentaDto.getNumeroCuenta());
        cuenta.setTipoCuenta(postCuentaDto.getTipoCuenta());
        cuenta.setSaldoInicial(postCuentaDto.getSaldoInicial());
        cuenta.setBalance(postCuentaDto.getBalance());
        cuenta.setEstado(postCuentaDto.getEstado());
        cuenta.setCliente(cliente);
        cuentaRepository.save(cuenta);
    }

    @Override
    public void actualizarCuenta(PutCuentaDto putCuentaDto, UUID id) {
        Optional<Cuenta> findCuenta = cuentaRepository.findById(id);

        if (findCuenta.isEmpty()){
            throw new NotFoundException("Cuenta No existe: " + id);
        }

        Cuenta cuenta = findCuenta.get();

        cuenta.setNumeroCuenta(putCuentaDto.getNumeroCuenta());
        cuenta.setTipoCuenta(putCuentaDto.getTipoCuenta());
        cuenta.setSaldoInicial(putCuentaDto.getSaldoInicial());
        cuenta.setBalance(putCuentaDto.getBalance());
        cuenta.setEstado(putCuentaDto.getEstado());
        cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminarCuentaId(UUID id) {
        Optional<Cuenta> findCuenta = cuentaRepository.findById(id);
        if(findCuenta.isEmpty()) {
            throw new NotFoundException("Cuenta No existe: " + id);
        }

        Cuenta cuenta = findCuenta.get();
        cuentaRepository.delete(cuenta);
    }
}
