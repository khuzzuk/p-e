package pl.projectE.model.government;

import pl.projectE.sec.LimitedAccess;

public class TaxPolicy {
    @LimitedAccess
    private long totalReceipts;
    @LimitedAccess
    private long gdp;
    @LimitedAccess
    private long investments;
    @LimitedAccess
    private long netWages;
}
