package com.immo_sim.api.mapper;

import com.immo_sim.api.dto.SimulationDto;
import com.immo_sim.api.entity.Simulation;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface SimulationMapper {
    SimulationDto simulationToSimulationDto(Simulation simulation);

    Simulation simulationDtoToSimulation(SimulationDto simulationDto);
}
