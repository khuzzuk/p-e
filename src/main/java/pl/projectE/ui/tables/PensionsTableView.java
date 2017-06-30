package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;

public class PensionsTableView extends TableView<Country> implements ColumnFactory<Country> {
    public PensionsTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("pensions funding", PERCENT, c -> c.pensions.governmentPensionFunding),
                getColumn("retirement age", SIMPLE, c -> c.pensions.retirementAge)
                );
    }
}
