package com.neoris.cliente.config;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ConfiguracionClienteWeb {

    private final ConfiguracionPropiedades configuracionPropiedades;

    @Bean
    public WebClient webClient()
    {
        HttpClient httpClient = HttpClient.create()
                .secure(sslContextSpec -> {
                    try {
                        sslContextSpec.sslContext(SslContextBuilder.forClient().trustManager(
                                InsecureTrustManagerFactory.INSTANCE).build());
                    }catch (SSLException ex){
                        log.error("Error on setting sslContext: {}", ex.getMessage());
                        throw new RuntimeException(ex);
                    }
                });

        return WebClient.builder()
                .baseUrl(configuracionPropiedades.getClienteCuentaUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
