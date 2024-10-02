package org.juliangranda.java.appmockito.ejemplos.services;

import org.juliangranda.java.appmockito.ejemplos.models.Examen;
import org.juliangranda.java.appmockito.ejemplos.repositories.ExamenRepository;
import org.juliangranda.java.appmockito.ejemplos.repositories.ExamenRepositoryOtro;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    @Test
    void findExamenPorNombre() {
        //Uso de framework Mockito
        //Solo se pueden hacer Mock de modificador de acceso publico.
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"),new Examen(6L, "Lenguaje"),
                new Examen(7L, "Historia"));

        //when es un metodo estatico de Mockito
        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5,examen.orElseThrow().getId());
        assertEquals("Matemáticas", examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        List<Examen> datos = Collections.emptyList();

        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent());
        assertEquals(5,examen.orElseThrow().getId());
        assertEquals("Matemáticas", examen.get().getNombre());
    }
}