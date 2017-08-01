package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.demography.Population;
import pl.projectE.model.economy.Employment;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.Administration;
import pl.projectE.model.government.Justice;
import pl.projectE.model.production.Product;
import pl.projectE.model.social.HealthCare;

public class Calculator {
    public static void calculate(Country country) {
        Population population = country.population;
        MacroIndicators macroIndicators = country.macroIndicators;
        Administration administration = country.administration;
        Justice justice = administration.justice;
        HealthCare healthCare = country.healthCare;
        Employment employment = country.employment;

        for (Product p : country.products) {
            p.actualProduction = p.employed * p.endProductivity;
        }

        //product prices here and there
        administration.administrationCost = AdministrationCalculations.administrationCost(country);
        healthCare.healthCareCost = HealthCareCalculations.healthCareCost(country);

        //population
        population.totalPopulation = PopulationCalculations.totalPopulation(population);
        population.laborForce = PopulationCalculations.popLaborForce(country);
        population.retired = PopulationCalculations.popRetired(country);
        population.underWorkingAge = PopulationCalculations.popUnderWorkingAge(country);
        population.nonLaborForceRatio = PopulationCalculations.nonLaborForceRatio(country);
        population.activeWorkForce = PopulationCalculations.activeLaborForce(country);
        population.popPerSqKm = PopulationCalculations.popPerSqKm(country);

        //macro inficators
        macroIndicators.gdpIn$ = MacroIndicatorsCalculations.gdpIn$(country);
        macroIndicators.gdpPerCapita = MacroIndicatorsCalculations.gdpPerCapita(country);
        macroIndicators.gdpPerCapita$ = MacroIndicatorsCalculations.gdpPerCapita$(country);
        macroIndicators.propensityToConsume = MacroIndicatorsCalculations.propensityToConsume(country);

        //administration
        administration.officialsSalaryTotal = AdministrationCalculations.officialsSalaryTotal(country);
        administration.officialsTotal = AdministrationCalculations.officialsTotal(country);
        administration.spending = AdministrationCalculations.spending(country);

        //employment
        employment.employed = EmploymentCalculations.employed(country);
        employment.unemployed = EmploymentCalculations.unemployed(country);
        employment.unemploymentRate = EmploymentCalculations.unemploymentRate(country);
        employment.employmentRate = EmploymentCalculations.employmentRate(country);
        employment.spending = EmploymentCalculations.spending(country);
    }
}
