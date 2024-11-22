package com.alexis.auto_diagnostic.service;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HealthIndexServiceTest {

    private final HealthIndexService service = new HealthIndexService();

    @Test
    public void testCardiacProblem() {
        List<String> result = service.getMedicalUnits(33);
        assertEquals(1, result.size());
        assertTrue(result.contains("Cardiologie"));
    }

    @Test
    public void testFracture() {
        List<String> result = service.getMedicalUnits(55);
        assertEquals(1, result.size());
        assertTrue(result.contains("Traumatologie"));
    }

    @Test
    public void testBothConditions() {
        List<String> result = service.getMedicalUnits(15);
        assertEquals(2, result.size());
        assertTrue(result.contains("Cardiologie"));
        assertTrue(result.contains("Traumatologie"));
    }

    @Test
    public void testInvalidHealthIndex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        service.getMedicalUnits(-5);  // Tester un index négatif
        });
        assertEquals("Health index must be greater than zero.", exception.getMessage());
    }

}