package pl.projectE.model.government;

import pl.projectE.math.DataType;
import pl.projectE.ui.ValueFormatter;

public class GovernmentFinances {
    @DataType(type = ValueFormatter.BIG)
    public long totalReceipts;

    @DataType(type = ValueFormatter.BIG)
    public transient long totalSpending;

    @DataType(type = ValueFormatter.BIG)
    public transient long payrollTaxation;
}
