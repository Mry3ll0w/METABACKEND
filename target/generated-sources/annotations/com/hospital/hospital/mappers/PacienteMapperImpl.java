package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.PacienteDTO;
import com.hospital.hospital.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:28:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Ubuntu)"
)
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteDTO toPacienteDTO(Paciente p) {
        if ( p == null ) {
            return null;
        }

        String nombre = null;
        String apellidos = null;
        String usuario = null;
        String nSS = null;
        String numTarjeta = null;

        nombre = p.getNombre();
        apellidos = p.getApellidos();
        usuario = p.getUsuario();
        nSS = p.getNSS();
        numTarjeta = p.getNumTarjeta();

        PacienteDTO pacienteDTO = new PacienteDTO( nombre, apellidos, usuario, nSS, numTarjeta );

        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> toListPacienteDTO(List<Paciente> p) {
        if ( p == null ) {
            return null;
        }

        List<PacienteDTO> list = new ArrayList<PacienteDTO>( p.size() );
        for ( Paciente paciente : p ) {
            list.add( toPacienteDTO( paciente ) );
        }

        return list;
    }
}
