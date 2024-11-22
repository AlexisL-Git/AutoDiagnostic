package com.alexis.auto_diagnostic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HealthIndexService {
    public List<String> getMedicalUnits(int healthIndex) {
        if (healthIndex <= 0) {
            throw new IllegalArgumentException("Health index must be greater than zero.");
        }

        List<String> units = new ArrayList<>();

        if (healthIndex % 3 == 0) {
            units.add("Cardiologie");
        }
        if (healthIndex % 5 == 0) {
            units.add("Traumatologie");
        }

        return units.isEmpty() ? List.of("No medical units found for the given index") : units;
    }
}
