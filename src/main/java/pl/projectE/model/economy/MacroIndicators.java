package pl.projectE.model.economy;

import pl.projectE.sec.LimitedAccess;

public class MacroIndicators {
    @LimitedAccess
    public int inflation;
    @LimitedAccess
    public int debtInterestRate;
    @LimitedAccess
    public int averageSalary;
    @LimitedAccess
    public int cci;
    @LimitedAccess
    public long gdp;
    @LimitedAccess
    public long investments;
    @LimitedAccess
    public long netWages;
}
