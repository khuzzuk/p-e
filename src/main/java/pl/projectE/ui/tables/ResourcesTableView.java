package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;


public class ResourcesTableView extends TableView<Country> implements ColumnFactory<Country> {
    public ResourcesTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("rCoal", PERCENT, c -> c.resources.rateCoal),
                getColumn("rCopper", PERCENT, c -> c.resources.rateCopper),
                getColumn("rIron", PERCENT, c -> c.resources.rateIron),
                getColumn("rUranium", PERCENT, c -> c.resources.rateUranium),
                getColumn("rOtherMining", PERCENT, c -> c.resources.rateOtherMining),
                getColumn("rPetroleum", PERCENT, c -> c.resources.ratePetroleum),
                getColumn("rNaturalGas", PERCENT, c -> c.resources.rateNaturalGas),
                getColumn("produCoal", SIMPLE, c -> c.resources.productionCoal),
                getColumn("produCopper", SIMPLE, c -> c.resources.productionCopper),
                getColumn("produIron", SIMPLE, c -> c.resources.productionIron),
                getColumn("produUranium", SIMPLE, c -> c.resources.productionUranium),
                getColumn("produOtherMining", SIMPLE, c -> c.resources.productionOtherMining),
                getColumn("produPetroleum", SIMPLE, c -> c.resources.productionPetroleum),
                getColumn("produNaturalGas", SIMPLE, c -> c.resources.productionNaturalGas)
                );
    }
}
