package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;

public class HealthCareTableView extends TableView<Country> implements ColumnFactory<Country> {
    public HealthCareTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("health condition", PERCENT, c -> c.healthCare.healthCondition),
                getColumn("health funding", PERCENT, c -> c.healthCare.healthFundingOfHealthCareNeeds),
                getColumn("doctors salary", PERCENT, c -> c.healthCare.healthMedicalStuffSalary)
        );
    }
}
