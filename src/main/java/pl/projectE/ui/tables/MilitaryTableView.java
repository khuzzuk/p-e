package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;

public class MilitaryTableView extends TableView<Country> implements ColumnFactory {
    public MilitaryTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("Equipment", CURRENCY, c -> c.military.equipmentCapital)
        );
    }
}
