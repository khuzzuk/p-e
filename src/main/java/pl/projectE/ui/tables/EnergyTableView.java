package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;


public class EnergyTableView extends TableView<Country> implements ColumnFactory {
    public EnergyTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("clean", PERCENT, c -> c.energy.clean),
                getColumn("conventional", PERCENT, c -> c.energy.conventional),
                getColumn("nuclear", PERCENT, c -> c.energy.nuclear)
                );
    }
}
