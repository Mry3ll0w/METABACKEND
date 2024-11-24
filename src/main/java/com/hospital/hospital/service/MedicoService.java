package com.hospital.hospital.service;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.dto.UsuarioDTO;
import com.hospital.hospital.mappers.MedicoMapper;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.model.Usuario;
import com.hospital.hospital.repository.MedicoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repo;

    @Autowired
    private UsuarioService userService;

    private final MedicoMapper mapper = MedicoMapper.INSTANCE;

    public void create(Medico m){
        repo.save(m);
    }

    public Optional<MedicoDTO> findMedicoByNumeroColegiado(String num){
        Optional<Medico> optM = repo.findBynumColegiado(num);

        /*
        * return optM.isPresent() ?
                    Optional.of(mapper.toMedicoDTO(optM.get()))
                    : Optional.empty();
        * Son lo mismo pero de forma mas abreviada
        * */
            return optM.map(mapper::toMedicoDTO);
    }
    
    public Optional<List<MedicoDTO>> findAllMedics(){
        Optional<List<Medico>> optListMedico = Optional.of(repo.findAll());
        //return optListMedico.isPresent() ? Optional.of()

        return optListMedico.map(mapper::toListMedicoDTO);
    }

    public void addPacienteToMedico(String nss, String numColegiado){

    }

    public boolean updateMedicoProperties(String name, Map<String, Object> updates) {

        //Primero Updateamos la parte de Usuario del Medico
        boolean updated = userService.updateUserProperties(name, updates);

        if (updated) {

            Optional<Medico> optMed = repo.findBynombre(
                    updates.get("nombre") == null ? name :(String) updates.get("nombre"));

            Medico med = optMed.get();// Va a estar presente ya que existe el usuario

            // Aplicar las actualizaciones
            updates.forEach((key, value) -> {
                if (Objects.equals(key, "numColegiado")) {
                  med.setNumColegiado((String) value);
                }
            });

            // Guardar usuario actualizado en la base de datos
            repo.save(med);
            return true;
        }

        return false; // Usuario no encontrado
    }

    public Optional<MedicoDTO> findMedicoByNombre(String name){
        Optional<Medico> optMedico = repo.findBynombre(name);
        //return optListMedico.isPresent() ? Optional.of()

        return optMedico.map(mapper::toMedicoDTO);
    }

    public void deleteMedico(String nombre){
        Optional<Medico> optMed = repo.findBynombre(nombre);
        optMed.ifPresent(medico -> repo.delete(medico));
    }


}
