package com.alexis.auto_diagnostic.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alexis.auto_diagnostic.service.HealthIndexService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/diagnostic")
public class HealthDiagnosticController {

    private final HealthIndexService healthIndexService;

    public HealthDiagnosticController(HealthIndexService healthIndexService) {
        this.healthIndexService = healthIndexService;
    }

    @Operation(summary = "Retrieve medical units based on health index",
               description = "Fetches a list of medical units matching the given health index")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the medical units"),
        @ApiResponse(responseCode = "400", description = "Invalid health index provided"),
        @ApiResponse(responseCode = "404", description = "No medical units found for the given index")
    })
    @GetMapping("/{healthIndex}")
    public ResponseEntity<List<String>> getMedicalUnits(@PathVariable int healthIndex) {
        try {
            List<String> medicalUnits = healthIndexService.getMedicalUnits(healthIndex);

            if (medicalUnits.contains("No medical units found for the given index")) {
                return ResponseEntity.status(404).body(medicalUnits);
            }
            
            return ResponseEntity.ok(medicalUnits);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(List.of("Health index must be greater than zero."));
        }
    }
}
