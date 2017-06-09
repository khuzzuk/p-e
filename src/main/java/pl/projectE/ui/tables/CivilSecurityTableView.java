package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;
import static pl.projectE.ui.ValueFormatter.PERCENT;

public class CivilSecurityTableView extends TableView<Country> implements ColumnFactory {
    public CivilSecurityTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("police equipment", CURRENCY, c -> c.civilSecurity.policeEquipmentCapital),
                getColumn("corruption", PERCENT, c -> c.civilSecurity.corruption),
                getColumn("crime rate", PERCENT, c -> c.civilSecurity.crimeRate),
                getColumn("imprisoned pop", PERCENT, c -> c.civilSecurity.imprisonedPopulation));
    }
}
