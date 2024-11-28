package com.hospital.hospital.controller;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.dto.MedicoPacienteDTO;
import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.service.MedicoPacienteService;
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

    @Autowired
    private MedicoPacienteService medicoPacienteService;

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

    @PatchMapping("/linkPaciente")
    public ResponseEntity<String> linkPacienteToMedico(@RequestBody MedicoPacienteDTO mp){
        boolean bIsUpdated = medicoPacienteService.addMedicoToPacienteByNumColegiado(mp.numColegiado(), mp.NSS());

        if (bIsUpdated) {
            return ResponseEntity.ok("Paciente vinculado a medico de forma correcta");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/pacientes/{numColegiado}")
    public Optional<List<PacienteDTO>> getAllPacientesFromMedico(@PathVariable String numColegiado){
        return medicoPacienteService.getAllPacientesFromMedico(numColegiado);
    }

    @DeleteMapping("/pacientes")
    public ResponseEntity<String> eraseLinkMedicoPaciente(@RequestBody MedicoPacienteDTO mp){
        boolean bIsDeleted = medicoPacienteService.deleteLinkPacienteMedico(mp.numColegiado(), mp.NSS());

        if (bIsDeleted) {
            return ResponseEntity.ok("Paciente desvinculado del medico");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}























