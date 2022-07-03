package com.immo_sim.api.dto;

import lombok.Data;

@Data
public class SimulationDto {

    private double afiPrice;

    private String city;

    private int postalCode;

    private double coowernshipFeesYear;

    private double surface;

    private double rent;
}
