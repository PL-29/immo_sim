package com.immo_sim.api.dto;

import lombok.Data;

@Data
public class SimulationDto {
    private Long id;

    // input fields
    private double afiPrice;
    private String city;
    private int postalCode;
    private double coowernshipFeesYear;
    private double surface;
    private double rent;

    //fields with a default value setted
    private double notaryFeesRate;
    private double agencyFeesRate;
    private double taxRate;
    private int loanDuration;
    private double interestsCostRate;
    private int monthOfOccupancyYear;

    // calculated fields
    private double agencyFees;
    private double priceWithoutAfi;
    private double notaryFees;
    private double monthlyLoanPayment;
    private double interestsCost;
    private double taxesMonth;
    private double grossProfitability;
}
