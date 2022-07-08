package com.immo_sim.api.service;

import com.immo_sim.api.entity.Simulation;
import com.immo_sim.api.repository.SimulationRepository;
import org.springframework.stereotype.Service;
import static com.immo_sim.api.constant.SimulationDefaultValues.*;

@Service
public class SimulationService {

    private final SimulationRepository simulationRepository;

    public SimulationService(SimulationRepository simulationRepository) {
        this.simulationRepository = simulationRepository;
    }

    //TODO: Rajouter un mapper dans la partie controller pour ne manipuler que des objets Simulation dans le service
    //Et que des DTO dans le controller
    public Simulation createSimulation(Simulation simulation) {
        //Set all default values for the first simulation, can be updated later
        simulation.setTaxRate(DEFAULT_TAX_RATE);
        simulation.setNotaryFeesRate(DEFAULT_NOTARY_FEES_RATE);
        simulation.setAgencyFeesRate(DEFAULT_AGENCY_FEES_RATE);
        simulation.setLoanDuration(DEFAULT_LOAN_DURATION);
        simulation.setInterestsCostRate(DEFAULT_INTERESTS_COST_RATE);
        simulation.setMonthOfOccupancyYear(DEFAULT_MONTH_OF_OCCUPANCY);

        setSimulationCalculatedFields(simulation);
        //TODO: ajouter une estimation taxe foncière et charges de copro (arbitraire pour l'instant, suivant surface / localisation plus tard)

        return simulationRepository.save(simulation);
    }

    private void setSimulationCalculatedFields(Simulation simulation) {
        setAgencyAndNotaryFeesFields(simulation);
        setLoanFields(simulation);
        setProfitabilityFields(simulation);
    }

    private void setAgencyAndNotaryFeesFields(Simulation simulation) {
        simulation.setAgencyFees(simulation.getAfiPrice() / (1 + simulation.getAgencyFeesRate()));
        simulation.setPriceWithoutAfi(simulation.getAfiPrice() - simulation.getAgencyFees());
        simulation.setNotaryFees(simulation.getPriceWithoutAfi() * (1 + simulation.getNotaryFeesRate()));
    }

    private void setLoanFields(Simulation simulation) {
        double loanAmount = simulation.getPriceWithoutAfi() + simulation.getNotaryFees() + simulation.getAgencyFees();
        simulation.setMonthlyLoanPayment(getMonthlyLoanPayment(loanAmount, simulation.getInterestsCostRate(), simulation.getLoanDuration()));
        simulation.setInterestsCost(getInterestsCost(loanAmount, simulation.getInterestsCostRate(), simulation.getLoanDuration()));
    }

    private void setProfitabilityFields(Simulation simulation) {
        simulation.setGrossProfitability(getGrossProfitability(simulation.getPriceWithoutAfi(), simulation.getRent(), simulation.getMonthOfOccupancyYear()));
        //Add net probitability cf calculs below
    }

    private double getMonthlyLoanPayment(double loanAmount, double interestsRate, int duration) {
        return loanAmount * (interestsRate / 12) / (1 - 1 / Math.pow(1 + (interestsRate / 12), duration * 12));
    }

    private double getInterestsCost(double loanAmount, double interestsRate, int duration) {
        return getMonthlyLoanPayment(loanAmount, interestsRate, duration) * 12 * 20;
    }

    private double getGrossProfitability(double priceWithoutAfi, double rent, int monthOfOccupancyYear) {
        return rent * monthOfOccupancyYear / priceWithoutAfi;
    }

//    private double getInterestsAmountFirstYear(double loanAmount, double interestsRate, int duration) {
//
//    }
    // calcul cf :  https://www.clickandrent.fr/post/rentabilite-brute-et-nette-mode-demploi#:~:text=La%20formule%20est%20simple%2C%20il,de%20votre%20rendement%20locatif%20brut.
//    private double getNetProbitability(double priceWithoutAfi, double notaryFees, double agencyFees, double rent, int monthOfOccupancyYear, )
}
