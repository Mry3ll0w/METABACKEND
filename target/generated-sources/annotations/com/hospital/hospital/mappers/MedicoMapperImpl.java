package com.hospital.hospital.mappers;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.model.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-17T08:09:54+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Ubuntu)"
)
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public MedicoDTO toMedicoDTO(Medico medico) {
        if ( medico == null ) {
            return null;
        }

        String nombre = null;
        String apellidos = null;
        String usuario = null;
        String numColegiado = null;

        nombre = medico.getNombre();
        apellidos = medico.getApellidos();
        usuario = medico.getUsuario();
        numColegiado = medico.getNumColegiado();

        MedicoDTO medicoDTO = new MedicoDTO( nombre, apellidos, usuario, numColegiado );

        return medicoDTO;
    }

    @Override
    public List<MedicoDTO> toListMedicoDTO(List<Medico> lMedicos) {
        if ( lMedicos == null ) {
            return null;
        }

        List<MedicoDTO> list = new ArrayList<MedicoDTO>( lMedicos.size() );
        for ( Medico medico : lMedicos ) {
            list.add( toMedicoDTO( medico ) );
        }

        return list;
    }
}
