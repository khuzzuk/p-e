package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.*;

public class LandTableView extends TableView<Country> implements ColumnFactory<Country> {
    public LandTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("total", BIG, c -> c.land.total),
                getColumn("arable", BIG, c -> c.land.arable),
                getColumn("habitable", BIG, c -> c.land.habitable),
                getColumn("roads", SIMPLE, c -> c.land.infrastructure.roads),
                getColumn("highways", SIMPLE, c -> c.land.infrastructure.highways),
                getColumn("railways", SIMPLE, c -> c.land.infrastructure.railways),
                getColumn("airports", SIMPLE, c -> c.land.infrastructure.airports),
                getColumn("docks", SIMPLE, c -> c.land.infrastructure.docks),
                getColumn("vehicles", SIMPLE, c -> c.land.infrastructure.vehicles),
                getColumn("roads tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.roads),
                getColumn("highways tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.highways),
                getColumn("railways tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.railways),
                getColumn("airports tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.airports),
                getColumn("docks tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.docks),
                getColumn("vehicles tech", PRECISE, c -> c.land.infrastructure.infrastructureTechnology.vehicles),
                getColumn("roads fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.roads),
                getColumn("highways fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.highways),
                getColumn("railways fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.railways),
                getColumn("airports fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.airports),
                getColumn("docks fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.docks),
                getColumn("vehicles fund", PERCENT, c -> c.land.infrastructure.infrastructureFunding.vehicles),
                getColumn("housing units", SIMPLE, c -> c.land.improvementsToLand.housingUnits));
    }
}
