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


    // default setted in simple simulation (can be edit on advanced simulation)
    @Column(name="tax_rate")
    private double taxRate;

    @Column(name="month_of_occupancy_year")
    private int monthOfOccupancyYear;

    @Column(name="agency_fees")
    private double agencyFees;

    @Column(name="notary_fees")
    private double notaryFees;

    @Column(name="loan_duration")
    private int loanDuration;

    @Column(name="interests_cost")
    private double interestsCost;

    @Column(name="insurance_cost")
    private double insuranceCost;

    @Column(name="taxes_month")
    private double taxesMonth;

    @Column(name="rental_tension")
    private RentalTension rentalTension;

    public Simulation() {
    }
}
