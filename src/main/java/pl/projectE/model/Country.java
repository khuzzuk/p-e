package pl.projectE.model;

import lombok.RequiredArgsConstructor;
import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.Employment;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.Administration;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.government.Military;
import pl.projectE.model.government.TaxPolicy;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.land.Infrastructure;
import pl.projectE.model.production.Energy;
import pl.projectE.model.social.*;

@RequiredArgsConstructor
public class Country implements Comparable<Country> {
    public final String name;
    public Administration administration;
    public Assets assets;
    public MacroIndicators macroIndicators;
    public Military military;
    public ImprovementsToLand improvementsToLand;
    public Infrastructure infrastructure;
    public CivilSecurity civilSecurity;
    public HealthCare healthCare;
    public Pensions pensions;
    public Employment employment;
    public SocialIndicators socialIndicators;
    public Education education;
    public Technology technology;
    public GovernmentFinances governmentFinances;
    public TaxPolicy taxPolicy;
    public Energy energy;

    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }
}
