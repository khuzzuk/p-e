package pl.projectE.model.economy;

import pl.projectE.sec.LimitedAccess;

public class MacroIndicators {
    @LimitedAccess
    public int inflation;
    @LimitedAccess
    private int debtInterestRate;
}
