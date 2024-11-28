package com.hospital.hospital.service;

import com.hospital.hospital.mappers.PacienteMapper;
import com.hospital.hospital.model.Cita;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.repository.CitaRepository;
import com.hospital.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteCitaService {

    @Autowired
    PacienteRepository pacienteRepo;

    @Autowired
    CitaRepository citaRepo;

    private PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    //Setter
    public boolean linkPacienteToCita(Integer atributo11, String nss){

        try{
            Optional<Cita> optionalCita = citaRepo.findByatributo11(atributo11);
            Optional<Paciente> optionalPaciente = pacienteRepo.findByNSS(nss);

            if(optionalPaciente.isPresent() && optionalCita.isPresent()){

                // Agregamos a cada uno y los tratamos
                Paciente p = optionalPaciente.get();
                Cita c = optionalCita.get();
                List<Cita> lCitas = p.getCitas();
                lCitas.add(c);
                p.setCitas(lCitas);

                // Seccion Cita
                c.setPaciente(p);

                citaRepo.save(c);
                pacienteRepo.save(p);

            }else{
                throw new Exception("NOT FOUND");
            }

            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

}

















