package com.hospital.hospital.service;

import com.hospital.hospital.mappers.MedicoMapper;
import com.hospital.hospital.model.Cita;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.repository.CitaRepository;
import com.hospital.hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoCitaService {

    @Autowired
    MedicoRepository medicoRepo;

    @Autowired
    CitaRepository citaRepo;

    private MedicoMapper medicoMapper = MedicoMapper.INSTANCE;

    //Setter
    public boolean linkMedicoToCita(Integer atributo11, String numColegiado){

        try{
            Optional<Cita> optionalCita = citaRepo.findByatributo11(atributo11);
            Optional<Medico> optionalMedico = medicoRepo.findBynumColegiado(numColegiado);

            if(optionalMedico.isPresent() && optionalCita.isPresent()){

                // Agregamos a cada uno y los tratamos
                Medico m = optionalMedico.get();
                Cita c = optionalCita.get();
                List<Cita> lCitas = m.getCitas();
                lCitas.add(c);
                m.setCitas(lCitas);

                // Seccion Cita
                c.setMedico(m);

                citaRepo.save(c);
                medicoRepo.save(m);

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
