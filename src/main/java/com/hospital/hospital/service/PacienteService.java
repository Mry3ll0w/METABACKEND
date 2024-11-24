package com.hospital.hospital.service;

import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.mappers.PacienteMapper;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.model.Paciente;
import com.hospital.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteService {

    /// Mapper y REPO
    private PacienteMapper mapper = PacienteMapper.INSTANCE;
    @Autowired
    private PacienteRepository repo;

    @Autowired
    private UsuarioService userService;

    public void createPaciente(Paciente p){
        repo.save(p);
    }

    public Optional<PacienteDTO> getPacienteByNSS(String nss){
        Optional<Paciente> optPaciente = repo.findByNSS(nss);
        return optPaciente.map(mapper::toPacienteDTO);
    }

    public Optional<PacienteDTO> getPacienteByNombre(String name){
        Optional<Paciente> optPaciente = repo.findByNombre(name);
        return optPaciente.map(mapper::toPacienteDTO);
    }

    public Optional<List<PacienteDTO>> getAllPacientes(){
        Optional<List<Paciente>> lPacientes = Optional.of(repo.findAll());
        return lPacientes.map(mapper::toListPacienteDTO);
    }

    public boolean updatePacienteProperties(String name, Map<String, Object> updates) {

        //Primero Updateamos la parte de Usuario del Medico
        boolean updated = userService.updateUserProperties(name, updates);

        //Tenemos que comprobar que el nombre no se ha cambiado en updates



        if (updated) {
            // Nos aseguramos que el nombre no se haya cambiado con anterioridad, si es asi se
            // busca con el nuevo nombre
            Optional<Paciente> optPaciente = repo.findByNombre(
                    updates.get("nombre") == null ? name :(String) updates.get("nombre")
            );

            Paciente pa = optPaciente.get();// Va a estar presente ya que existe el usuario

            // Aplicar las actualizaciones
            updates.forEach((key, value) -> {
                switch (key) {
                    case "nss":
                        pa.setNSS((String) value);//Cast a String p
                        break;
                    case "numTarjeta":
                        pa.setNumTarjeta((String) value);
                        break;
                    case "telefono":
                        pa.setTelefono((String) value);
                        break;
                    case "direccion":
                        pa.setDireccion((String) value);
                        break;
                    default:
                        break;//Si se introduce un campo no valido no se hace nada, mayor compatibilidad entre usuario, Medico y Paciente
                }
            });

            // Guardar usuario actualizado en la base de datos
            repo.save(pa);
            return true;
        }

        return false; // Usuario no encontrado
    }
}













