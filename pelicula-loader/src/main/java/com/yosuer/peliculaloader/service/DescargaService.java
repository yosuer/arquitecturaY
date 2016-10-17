package com.yosuer.peliculaloader.service;

import com.yosuer.peliculaloader.domain.Descarga;
import com.yosuer.peliculaloader.domain.PeliculaImdb;

public interface DescargaService {

    Descarga crear(PeliculaImdb peliculaImdb);

}
