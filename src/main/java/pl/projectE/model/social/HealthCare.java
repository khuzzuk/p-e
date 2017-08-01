package pl.projectE.model.social;


import pl.projectE.math.DataType;
import pl.projectE.ui.ValueFormatter;

public class HealthCare {
    @DataType(type = ValueFormatter.SIMPLE)
    public int healthCondition;
    @DataType(type = ValueFormatter.PERCENT)
    public int healthFundingOfHealthCareNeeds;
    @DataType(type = ValueFormatter.PERCENT)
    public int healthMedicalStuffSalary;
    @DataType(type = ValueFormatter.PRECISE)
    public transient int healthCareCost;
}
