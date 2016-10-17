package com.yosuer.peliculaloader.service.impl;

import com.yosuer.peliculaloader.domain.Descarga;
import com.yosuer.peliculaloader.domain.PeliculaImdb;
import com.yosuer.peliculaloader.repository.PeliculaRepository;
import com.yosuer.peliculaloader.service.DescargaService;
import com.yosuer.peliculaloader.vo.PeliculaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescargaServiceImpl implements DescargaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Descarga crear(PeliculaImdb peliculaImdb) {
        Descarga descarga = new Descarga();
        PeliculaVo pv = generarPeliculaVo(peliculaImdb);
        descarga.setPeliculaVo(peliculaRepository.save(pv));
        return descarga;
    }

    private PeliculaVo generarPeliculaVo(PeliculaImdb peliculaImdb) {
        PeliculaVo peliculaVo = new PeliculaVo();
        peliculaVo.setTitulo(peliculaImdb.getTitle());
        peliculaVo.setPais(peliculaImdb.getCountry());
        peliculaVo.setGenero(peliculaImdb.getGenre());
        peliculaVo.setImagen(peliculaImdb.getPoster());
        peliculaVo.setDescripcion(peliculaImdb.getPlot());
        peliculaVo.setAnio(Integer.valueOf(peliculaImdb.getYear()));

        return peliculaVo;
    }

}
