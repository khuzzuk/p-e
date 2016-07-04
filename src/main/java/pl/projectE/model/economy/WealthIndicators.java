package pl.projectE.model.economy;

import pl.projectE.sec.LimitedAccess;

public class WealthIndicators {
    @LimitedAccess
    public int averageSalary;
    @LimitedAccess
    public int cci;
}
