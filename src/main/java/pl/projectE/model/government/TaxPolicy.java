package pl.projectE.model.government;

import pl.projectE.sec.LimitedAccess;

public class TaxPolicy {
    @LimitedAccess
    public int pitLowMargin;
    @LimitedAccess
    public int pitMediumMargin;
    @LimitedAccess
    public int pitHighMargin;
    @LimitedAccess
    public int pitLowMarginThreshold;
    @LimitedAccess
    public int pitMediumMarginThreshold;
    @LimitedAccess
    public int payroll;
    @LimitedAccess
    public int cit;
    @LimitedAccess
    public int redundancy;
    @LimitedAccess
    public int vat;
    @LimitedAccess
    public int sales;
    @LimitedAccess
    public int tariff;
    @LimitedAccess
    public int fromLandOwnership;
    @LimitedAccess
    public int improvementsToLand;
    @LimitedAccess
    public int movableProperty;
    @LimitedAccess
    public int inheritance;
    @LimitedAccess
    public int capitalGains;
    @LimitedAccess
    public int financialTransactions;
    @LimitedAccess
    public int tolls;
    @LimitedAccess
    public int crimeFees;
    @LimitedAccess
    public boolean governmentEmployee;
    @LimitedAccess
    public boolean governmentBenefactors;
}
