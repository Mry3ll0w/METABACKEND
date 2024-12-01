package com.hospital.hospital;

import static org.junit.Assert.*;

import com.hospital.hospital.dto.CitaDTO;
import com.hospital.hospital.model.Cita;
import com.hospital.hospital.service.CitaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitaServiceTestJunit {

    @Autowired
    private CitaService citaService;
    private Date currDate = new Date();
    @Before
    public void createTestEntity(){

        Cita c = new Cita();
        c.setAtributo11(11);
        c.setMotivoCita("Testing");
        c.setFechaHora(currDate);

        citaService.create(c);

    }

    @Test
    public void test() {
        CitaDTO dtoC = citaService.getCitaByAtributo11(11).get();// No puede fallar puesto que se ha creado previamente
        assertEquals("Testing",dtoC.motivoCita());
        assertEquals(this.currDate, dtoC.fechaHora());
    }

    @After
    public void cleanTestEntity(){
        citaService.eraseCitaByAtributo11(11);
    }

}