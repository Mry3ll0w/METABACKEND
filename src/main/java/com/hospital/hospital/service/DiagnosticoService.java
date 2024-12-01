package com.hospital.hospital.service;

import com.hospital.hospital.dto.DiagnosticoDTO;
import com.hospital.hospital.mappers.DiagnosticoMapper;
import com.hospital.hospital.model.Diagnostico;
import com.hospital.hospital.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repo;

    private DiagnosticoMapper mapper = DiagnosticoMapper.INSTANCE;

    public void createDiagnostico(Diagnostico d){
        repo.save(d);
    }

    public Optional<List<DiagnosticoDTO>> getAllDiagnosticos(){

        return Optional.of(mapper.toListDiagnosticoDTO(repo.findAll()));

    }

    public Optional<List<DiagnosticoDTO>> getAllDiagnosticosByEnfermedad(String enfermedad){

        Optional<List<Diagnostico>> optLDiag = repo.findByenfermedad(enfermedad);
        return optLDiag.map(diagnosticos -> mapper.toListDiagnosticoDTO(diagnosticos));

    }



}
