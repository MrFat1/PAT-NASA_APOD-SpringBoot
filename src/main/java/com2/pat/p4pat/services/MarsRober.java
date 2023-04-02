package com2.pat.p4pat.services;

import com2.pat.p4pat.domain.IMGGallery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface MarsRober {

    Object getGallery(IMGGallery gallery); //Mandamos el formulario al impl

}
