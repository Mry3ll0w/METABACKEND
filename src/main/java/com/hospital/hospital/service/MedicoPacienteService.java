package com.hospital.hospital.service;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.mappers.MedicoMapper;
import com.hospital.hospital.mappers.PacienteMapper;
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

    private MedicoMapper medicoMapper = MedicoMapper.INSTANCE;

    private PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

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

    // GETTERS

    public Optional<List<MedicoDTO>> getAllMedicosFromPaciente(String NSS){

        //Primero pillamos el paciente
        Optional<Paciente> optPaciente = pacienteRepo.findByNSS(NSS);
        if(optPaciente.isPresent()){
            Paciente p = optPaciente.get();
            return Optional.of(medicoMapper.toListMedicoDTO(p.getMedicos()));
        }else
            return Optional.empty();

    }

    public Optional<List<PacienteDTO>> getAllPacientesFromMedico(String numColegiado){
        //Primero pillamos el paciente
        Optional<Medico> optMedico = medicoRepo.findBynumColegiado(numColegiado);
        if(optMedico.isPresent()){
            Medico m = optMedico.get();
            return Optional.of(pacienteMapper.toListPacienteDTO(m.getPacientes()));
        }else
            return Optional.empty();
    }




    // DELETE SINGLETON
    public boolean deleteLinkPacienteMedico(String numColegiado, String nss){

        try{
            Optional<Medico> optMed = medicoRepo.findBynumColegiado(numColegiado);
            Optional<Paciente> optPaciente = pacienteRepo.findByNSS(nss);
            if(optMed.isPresent() && optPaciente.isPresent()){
                Medico m = optMed.get();
                Paciente p = optPaciente.get();
                // Eliminamos ese elemento de la relacion

                // Primero de medico
                List<Paciente> lPacientes = m.getPacientes();
                lPacientes.remove(p);
                m.setPacientes(lPacientes);

                // Despues de paciente
                List<Medico> lMedicos = p.getMedicos();
                lMedicos.remove(m);

                // Guardamos
                medicoRepo.save(m);
                pacienteRepo.save(p);

                return true;

            }else
                return false;
        }catch (Exception e){
            return false;
        }

    }



}














