package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY;
import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;

public class MilitaryTableView extends TableView<Country> implements ColumnFactory {
    public MilitaryTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("Equipment", CURRENCY, c -> c.military.equipmentCapital),
                getColumn("soldiers", PERCENT, c -> c.military.soldiers),
                getColumn("soldiersSalary", PERCENT, c -> c.military.soldiersSalary),
                getColumn("ConscriptionStartingAge", SIMPLE, c -> c.military.nationalConscriptionStartingAge),
                getColumn("ConscriptionEndingAge", SIMPLE, c -> c.military.nationalConscriptionEndingAge),
                getColumn("militaryEquipmentFunding", PERCENT, c -> c.military.militaryEquipmentFunding)
        );
    }
}
