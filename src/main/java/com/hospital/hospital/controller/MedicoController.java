package com.hospital.hospital.controller;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medic")
public class MedicoController
{
    @Autowired
    private MedicoService service;

    @PostMapping("/create")
    public void createMedic(@RequestBody Medico m){
        service.create(m);
    }

    @GetMapping
    public Optional<List<MedicoDTO>> getAllMedicos(){
        return service.findAllMedics();
    }

}
