package com.yosuer.peliculaloader.repository.impl;

import com.yosuer.peliculaloader.repository.PeliculaRepository;
import com.yosuer.peliculaloader.vo.PeliculaVo;
import java.net.URI;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class PeliculaRepositoryImpl implements PeliculaRepository {

    private static final Logger logger = getLogger(PeliculaRepositoryImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${com.yosuer.pelicula-loader.apipelicula.url}")
    private String urlPelicula;

    @Override
    public PeliculaVo save(PeliculaVo peliculaVo) {
        URI uriApi = UriComponentsBuilder
                .fromHttpUrl(urlPelicula)
                .build().toUri();

        logger.info("Realizando petición a: {}", uriApi);
        return restTemplate.postForObject(uriApi, peliculaVo, PeliculaVo.class);
    }

}
