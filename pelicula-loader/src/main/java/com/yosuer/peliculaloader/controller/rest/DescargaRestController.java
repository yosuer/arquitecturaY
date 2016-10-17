package com.yosuer.peliculaloader.controller.rest;

import com.yosuer.peliculaloader.domain.Descarga;
import com.yosuer.peliculaloader.domain.PeliculaImdb;
import com.yosuer.peliculaloader.service.DescargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/descarga")
public class DescargaRestController {

    @Autowired
    private DescargaService descargaService;

    @PostMapping
    public Descarga descargarPelicula(@RequestBody PeliculaImdb peliculaImdb) {
        return descargaService.crear(peliculaImdb);
    }
}
