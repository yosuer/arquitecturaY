package com.yosuer.appserver.controller.rest;

import com.yosuer.appserver.domain.Pelicula;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "peliculas", path = "peliculas")
public interface PeliculaRestController extends MongoRepository<Pelicula, String> {

    List<Pelicula> findByTitulo(@Param("titulo") String titulo);

}
