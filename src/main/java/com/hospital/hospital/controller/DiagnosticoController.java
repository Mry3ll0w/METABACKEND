package com.hospital.hospital.controller;

import com.hospital.hospital.dto.DiagnosticoDTO;
import com.hospital.hospital.mappers.DiagnosticoMapper;
import com.hospital.hospital.model.Diagnostico;
import com.hospital.hospital.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService service;

    private DiagnosticoMapper mapper = DiagnosticoMapper.INSTANCE;

    @GetMapping
    public Optional<List<DiagnosticoDTO>> getAllDiagnosticos(){
        return service.getAllDiagnosticos();
    }

    @PostMapping("/create")
    public void create(@RequestBody Diagnostico d){
        service.createDiagnostico(d);
    }

}













