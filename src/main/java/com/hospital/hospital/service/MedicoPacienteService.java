package com.hospital.hospital.service;

import com.hospital.hospital.model.Medico;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.repository.MedicoRepository;
import com.hospital.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoPacienteService {


    @Autowired
    MedicoRepository medicoRepo;

    @Autowired
    PacienteRepository pacienteRepo;

    /// Agrega un paciente usando el numero de colegiado del medico y el numero de seguridad social del paciente
    public boolean addMedicoToPacienteByNumColegiado(String numColegiado, String NSS){

        // Primero obtenemos Paciente y medico para hacer la relacion
        Optional<Paciente> optPaciente = pacienteRepo.findByNSS(NSS);
        Optional<Medico> optMed = medicoRepo.findBynumColegiado(numColegiado);

        // Si no hay medico o paciente entonces fuera.
        if(optMed.isPresent() && optPaciente.isPresent()){
            // Sacamos a los objetos de verdad
            Medico med = optMed.get();
            Paciente pac = optPaciente.get();

            // Comprobamos que la lista no de null
            // Si alguno de los dos es null se ha dado un problema.
            if(pac.getMedicos() != null && med.getPacientes() != null){
                pac.getMedicos().add(med);
                med.getPacientes().add(pac);

                // Guardamos en BBDD
                medicoRepo.save(med);
                pacienteRepo.save(pac);

            }else
                return false;

        }
        else
            return false;


        //Si no peta devuelvo false
        return true;
    }

    // GETTER SINGLETON

    // UPDATE SINGLETON

    // DELETE SINGLETON



}
