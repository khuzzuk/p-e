package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;
import static pl.projectE.ui.ValueFormatter.PERCENT;

public class HealthCareTableView extends TableView<Country> implements ColumnFactory {
    public HealthCareTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("", PERCENT, c -> c.healthCare.healthCondition)
                );
    }
}
