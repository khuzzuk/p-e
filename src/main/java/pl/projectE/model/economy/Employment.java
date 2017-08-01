package pl.projectE.model.economy;

import pl.projectE.math.DataType;
import pl.projectE.ui.ValueFormatter;

public class Employment {
    @DataType(type = ValueFormatter.PERCENT)
    public int unemploymentBenefits;
    public int unemploymentBenefitsDuration;
    public int unemploymentBenefitsStrength;
    @DataType(type = ValueFormatter.SIMPLE)
    public int workingAge;
    @DataType(type = ValueFormatter.PERCENT)
    public int minimumSalary;
    @DataType(type = ValueFormatter.BIG)
    public transient long employed;
    @DataType(type = ValueFormatter.BIG)
    public transient long unemployed;
    @DataType(type = ValueFormatter.PERCENT)
    public transient int unemploymentRate;
    @DataType(type = ValueFormatter.PERCENT)
    public transient int employmentRate;
    @DataType(type = ValueFormatter.BIG)
    public transient long spending;
}
