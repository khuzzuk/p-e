package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;

public class TechnologyTableView extends TableView<Country> implements ColumnFactory {
    public TechnologyTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("", CURRENCY, c -> c.socialIndicators.educatedPopulation),
                getColumn("", CURRENCY, c -> c.socialIndicators.familyValues)
        );
    }
}
