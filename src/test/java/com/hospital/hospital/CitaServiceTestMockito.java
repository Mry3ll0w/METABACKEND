package com.hospital.hospital;

import com.hospital.hospital.dto.CitaDTO;
import com.hospital.hospital.mappers.CitaMapper;
import com.hospital.hospital.model.Cita;
import com.hospital.hospital.repository.CitaRepository;
import com.hospital.hospital.service.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CitaServiceTestMockito {

    @Mock
    private CitaRepository citaRepo; // Simula el repositorio

    @InjectMocks
    private CitaService citaService; // Clase bajo prueba

    private final CitaMapper mapper = CitaMapper.INSTANCE; // Mapper real

    private Cita testCita;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa Mockito

        // Configurar una cita de prueba
        testCita = new Cita();
        testCita.setAtributo11(11);
        testCita.setMotivoCita("Testing");
        testCita.setFechaHora(new Date());
    }

    @Test
    public void testCreate() {
        // Simular comportamiento del repositorio
        when(citaRepo.save(any(Cita.class))).thenReturn(testCita);

        // Llamar al método del servicio
        citaService.create(testCita);

        // Verificar que se llamó a save() en el repositorio
        verify(citaRepo, times(1)).save(testCita);
    }

    @Test
    public void testGetCitaByAtributo11() {
        // Simular el repositorio devolviendo una cita
        when(citaRepo.findByatributo11(11)).thenReturn(Optional.of(testCita));

        // Llamar al método del servicio
        Optional<CitaDTO> result = citaService.getCitaByAtributo11(11);

        // Verificar que el resultado es correcto
        assertTrue(result.isPresent());
        assertEquals("Testing", result.get().motivoCita());
        assertEquals(testCita.getFechaHora(), result.get().fechaHora());

        // Verificar que se llamó a findByatributo11() en el repositorio
        verify(citaRepo, times(1)).findByatributo11(11);
    }

    @Test
    public void testUpdateUserProperties() {
        // Simular el repositorio devolviendo una cita existente
        when(citaRepo.findByatributo11(11)).thenReturn(Optional.of(testCita));

        // Crear actualizaciones
        Map<String, Object> updates = Map.of("motivoCita", "Updated");

        // Llamar al metodo del servicio
        boolean updated = citaService.updateUserProperties(11, updates);

        // Verificar que se actualizó correctamente
        assertTrue(updated);
        assertEquals("Updated", testCita.getMotivoCita());

        // Verificar que se llamó a save() en el repositorio
        verify(citaRepo, times(1)).save(testCita);
    }

    @Test
    public void testEraseCitaByAtributo11() {
        // Simular el repositorio devolviendo una cita
        when(citaRepo.findByatributo11(11)).thenReturn(Optional.of(testCita));

        // Llamar al método del servicio
        boolean erased = citaService.eraseCitaByAtributo11(11);

        // Verificar que se eliminó correctamente
        assertTrue(erased);

        // Verificar que se llamó a delete() en el repositorio
        verify(citaRepo, times(1)).delete(testCita);
    }

    @Test
    public void testEraseCitaByAtributo11_NotFound() {
        // Simular el repositorio devolviendo vacío
        when(citaRepo.findByatributo11(11)).thenReturn(Optional.empty());

        // Llamar al método del servicio
        boolean erased = citaService.eraseCitaByAtributo11(11);

        // Verificar que no se eliminó
        assertFalse(erased);

        // Verificar que no se llamó a delete()
        verify(citaRepo, never()).delete(any());
    }
}