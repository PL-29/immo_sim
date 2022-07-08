package com.immo_sim.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="simulation")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // input fields
    @Column(name="afi_price")
    private double afiPrice;

    private String city;
    @Column(name="postal_code")
    private int postalCode;
    @Column(name="coowernship_fees_year")
    private double coowernshipFeesYear;
    private double surface;
    private double rent;

    //fields with a default value setted
    @Column(name="notary_fees_rate")
    private double notaryFeesRate;
    @Column(name="agency_fees_rate")
    private double agencyFeesRate;
    @Column(name="tax_rate")
    private double taxRate;
    @Column(name="loan_duration")
    private int loanDuration;
    @Column(name="interests_cost_rate")
    private double interestsCostRate;
    @Column(name="month_of_occupancy_year")
    private int monthOfOccupancyYear;

    // calculated fields
    @Column(name="agency_fees")
    private double agencyFees;
    @Column(name="price_without_afi")
    private double priceWithoutAfi;
    @Column(name="notary_fees")
    private double notaryFees;

    @Column(name="interests_cost")
    private double monthlyLoanPayment;
    @Column(name="interests_cost")
    private double interestsCost;
    @Column(name="taxes_month")
    private double taxesMonth;
    @Column(name="gross_profitability")
    private double grossProfitability;
}
