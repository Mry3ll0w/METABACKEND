package com.hospital.hospital.service;

import com.hospital.hospital.dto.MedicoDTO;
import com.hospital.hospital.mappers.MedicoMapper;
import com.hospital.hospital.model.Medico;
import com.hospital.hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repo;

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

}
