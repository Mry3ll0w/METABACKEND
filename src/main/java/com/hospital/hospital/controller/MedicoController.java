package com.hospital.hospital.controller;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
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

    @GetMapping("/{numColegiado}")
    public Optional<MedicoDTO> getOneMedicoByNumColegiado(@PathVariable String numColegiado){

        return service.findMedicoByNumeroColegiado(numColegiado);

    }
    
    @PatchMapping("/{name}")
    public ResponseEntity<String> updateMedicoProperties(@PathVariable String name, @RequestBody Map<String, Object> updates){
        boolean bIsUpdated = service.updateMedicoProperties(name, updates);

        if (bIsUpdated) {
            return ResponseEntity.ok("Medico actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{name}")
    public void eraseMedicoFromDB(@PathVariable String name){
        service.deleteMedico(name);
    }

//    @GetMapping("/{name}")
//    public Optional<MedicoDTO> getOneMedicoByName(@PathVariable String name){
//        return service.findMedicoByNombre(name);
//    }

}























