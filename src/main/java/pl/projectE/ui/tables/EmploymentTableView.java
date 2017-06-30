package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;

public class EmploymentTableView extends TableView<Country> implements ColumnFactory<Country> {
    public EmploymentTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("working age", SIMPLE, c -> c.employment.workingAge),
                getColumn("minimum salary", PERCENT, c -> c.employment.minimumSalary),
                getColumn("unemployment benefits", PERCENT, c -> c.employment.unemploymentBenefits),
                getColumn("strength", PERCENT, c -> c.employment.unemploymentBenefitsStrength),
                getColumn("duration", PERCENT, c -> c.employment.unemploymentBenefitsDuration)
        );
    }
}
