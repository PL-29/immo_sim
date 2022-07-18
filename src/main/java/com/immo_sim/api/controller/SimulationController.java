package com.immo_sim.api.controller;

import com.immo_sim.api.dto.SimulationDto;
import com.immo_sim.api.entity.Simulation;
import com.immo_sim.api.mapper.SimulationMapper;
import com.immo_sim.api.service.SimulationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulationController {

    private SimulationService simulationService;
    private SimulationMapper simulationMapper;

    public SimulationController(SimulationService simulationService, SimulationMapper simulationMapper) {
        this.simulationService = simulationService;
        this.simulationMapper = simulationMapper;
    }

    @PostMapping("/simulations")
    public SimulationDto createSimulation(@RequestBody SimulationDto simulationDto) {
        Simulation simulation = simulationMapper.simulationDtoToSimulation(simulationDto);
        simulation = simulationService.createSimulation(simulation);
        return simulationMapper.simulationToSimulationDto(simulation);
    }
}
