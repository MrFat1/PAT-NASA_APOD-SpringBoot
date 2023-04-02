package com2.pat.p4pat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com2.pat.p4pat.domain.IMGGallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoberImpl implements MarsRober{

    private String key =  "&api_key=jhGISIlXsL9Xw2d93pdklkpvOc9TUKjPJGyTaB6M";

    Logger log = LoggerFactory.getLogger(RoberImpl.class);

    @Override
    public Object getGallery(IMGGallery gallery) {

        log.info("===================== Obteniendo imagenes del Mars Rober ===================");

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + gallery.getEarth_date() + "&camera=" + gallery.getCamera() + key;

        log.info("Url completo: " + url);

        log.info("LLamando a la API...");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);

        log.info("Status code: " + result.getStatusCode());

        //Error handler for empty response
        /*
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(result.getBody());
        JsonNode name = root.path("photos");
         */

        log.info("Objeto devuelto: " + result.getBody());

        return  result;


    }

}
