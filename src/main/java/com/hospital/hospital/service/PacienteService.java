package com.hospital.hospital.service;

import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.mappers.PacienteMapper;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    /// Mapper y REPO
    private PacienteMapper mapper = PacienteMapper.INSTANCE;
    @Autowired
    private PacienteRepository repo;

    void createPaciente(Paciente p){
        repo.save(p);
    }

    Optional<PacienteDTO> getPacienteByNSS(String nss){
        Optional<Paciente> optPaciente = repo.findByNSS(nss);
        return optPaciente.map(mapper::toPacienteDTO);
    }

    Optional<List<PacienteDTO>> getAllPacientes(){
        Optional<List<Paciente>> lPacientes = Optional.of(repo.findAll());
        return lPacientes.map(mapper::toListPacienteDTO);
    }
}













