package com.hospital.hospital.controller;

import com.hospital.hospital.model.Cita;
import com.hospital.hospital.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    CitaService service;


    @PostMapping("/create")
    public String createCita(@RequestBody Cita c){
        service.create(c);
        return "Creado";
    }



}
