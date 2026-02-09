package com.neoris.cliente.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties
@Configuration
public class ConfiguracionPropiedades {

    @Value("${cliente.cuenta.baseUrl}")
    private String ClienteCuentaUrl;

    @Value("${cliente.cuenta.movimientos.path}")
    private String ClienteCuentaMovimientosPath;
}
