package com.hospital.hospital;

import static org.junit.Assert.*;

import com.hospital.hospital.dto.CitaDTO;
import com.hospital.hospital.service.CitaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    @Autowired
    private CitaService citaService;
    @Test
    public void test() {
        CitaDTO dtoC = citaService.getCitaByAtributo11(55).get();
        assertEquals("Consulta gener",dtoC.motivoCita());
    }
}