package com2.pat.p4pat.controler;

import com2.pat.p4pat.domain.IMGGallery;
import com2.pat.p4pat.services.MarsRober;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoberControler {

    Logger log = LoggerFactory.getLogger(RoberControler.class);

    @Autowired
    MarsRober mrs;

    @PostMapping(path = "/mrsRober",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public Object imgs(@RequestBody IMGGallery gallery) { //Creamos una clase IMGGallery con la info del formulario

        log.info("Objeto 'IMGGallery' generado con el POST: " + gallery.toString());

        return mrs.getGallery(gallery);
    }


}
