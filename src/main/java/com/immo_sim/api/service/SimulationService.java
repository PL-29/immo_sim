package com.immo_sim.api.service;

import com.immo_sim.api.entity.Simulation;
import com.immo_sim.api.repository.SimulationRepository;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private SimulationRepository simulationRepository;

    public SimulationService(SimulationRepository simulationRepository) {
        this.simulationRepository = simulationRepository;
    }

    //TODO: Rajouter un mapper dans la partie controller pour ne manipuler que des objets Simulation dans le service
    //Et que des DTO dans le controller
    public Simulation createSimulation(Simulation simulation) {

        return null;
    }
}
