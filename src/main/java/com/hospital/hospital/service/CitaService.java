package com.hospital.hospital.service;

import com.hospital.hospital.dto.CitaDTO;
import com.hospital.hospital.mappers.CitaMapper;
import com.hospital.hospital.model.Cita;
import com.hospital.hospital.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepo;

    private CitaMapper mapper = CitaMapper.INSTANCE;

    // SET
    public void create(Cita c){
        citaRepo.save(c);
    }

    // GET

    public Optional<CitaDTO> getCitaByAtributo11(Integer atributo11){
        Optional<Cita> c = citaRepo.findByatributo11(atributo11);
        return c.map(mapper::toCitaDTO);
    }

    // UPDATE

    public boolean updateUserProperties(Integer atributo11, Map<String, Object> updates) {
        Optional<Cita> c = citaRepo.findByatributo11(atributo11);

        if (c.isPresent()) {
            Cita cita = c.get();// Al estar presente lo "sacamos" (de opt a Usuario)

            // Aplicar las actualizaciones
            updates.forEach((key, value) -> {
                switch (key) {
                    case "fechaHora":
                        cita.setFechaHora((Date) value);//Cast a String p
                        break;
                    case "motivoCita":
                        cita.setMotivoCita((String) value);
                        break;
                    case "atributo11":
                        cita.setAtributo11((Integer) value);
                        break;
                    default:
                        break;//Si se introduce un campo no valido no se hace nada, mayor compatibilidad entre usuario, Medico y Paciente
                }
            });

            // Guardar usuario actualizado en la base de datos
            citaRepo.save(cita);
            return true;
        }else
            return false;
    }
}









