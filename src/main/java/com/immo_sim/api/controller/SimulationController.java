package com.immo_sim.api.controller;

import com.immo_sim.api.dto.SimulationDto;
import com.immo_sim.api.entity.Simulation;
import com.immo_sim.api.service.SimulationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulationController {

    private SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/simulations")
    public Simulation createSimulation(@RequestBody SimulationDto simulationDto) {

        return null;
    }
}
