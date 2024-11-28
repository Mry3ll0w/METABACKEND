package com.hospital.hospital.controller;
import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.dto.MedicoPacienteDTO;
import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.service.MedicoPacienteService;
import com.hospital.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private MedicoPacienteService medicoPacienteService;

    @PostMapping
    public void createPaciente(@RequestBody Paciente p){
        service.createPaciente(p);
    }

    @GetMapping
    public Optional<List<PacienteDTO>> getAllPacientes(){
        return service.getAllPacientes();
    }

    @GetMapping("/{name}")
    public Optional<PacienteDTO> getOnePacienteByName(@PathVariable String name){
        return service.getPacienteByNombre(name);
    }

    @PatchMapping("/{name}")
    public ResponseEntity<String> updatePacienteProperties(@PathVariable String name,
                                                           @RequestBody Map<String, Object> updates)
    {
        boolean bIsUpdated = service.updatePacienteProperties(name, updates);

        if (bIsUpdated) {
            return ResponseEntity.ok("Paciente actualizado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/linkMedico")
    public ResponseEntity<String> linkPacienteToMedico(@RequestBody MedicoPacienteDTO mp){
        boolean bIsUpdated = medicoPacienteService.addMedicoToPacienteByNumColegiado(mp.numColegiado(), mp.NSS());

        if (bIsUpdated) {
            return ResponseEntity.ok("Paciente vinculado a medico de forma correcta");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/medicos/{nss}")
    public Optional<List<MedicoDTO>> getAllMedicosFromPaciente(@PathVariable String nss){
        return medicoPacienteService.getAllMedicosFromPaciente(nss);
    }

    @DeleteMapping("/medicos")
    public ResponseEntity<String> eraseLinkMedicoPaciente(@RequestBody MedicoPacienteDTO mp){
        boolean bIsDeleted = medicoPacienteService.deleteLinkPacienteMedico(mp.numColegiado(), mp.NSS());

        if (bIsDeleted) {
            return ResponseEntity.ok("Paciente desvinculado del medico");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}















