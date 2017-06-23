package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.CURRENCY_PRECISE;
import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;

public class InfrastructureTableView extends TableView<Country> implements ColumnFactory {
    public InfrastructureTableView() {
        getColumns().addAll(getColumnWithString("Country", c -> c.name),
                getColumn("roads", SIMPLE, c -> c.infrastructure.roads),
                getColumn("highways", SIMPLE, c -> c.infrastructure.highways),
                getColumn("railways", SIMPLE, c -> c.infrastructure.railways),
                getColumn("airports", SIMPLE, c -> c.infrastructure.airports),
                getColumn("docks", SIMPLE, c -> c.infrastructure.docks),
                getColumn("vehicles", SIMPLE, c -> c.infrastructure.vehicles),
                getColumn("roads tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.roads),
                getColumn("highways tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.highways),
                getColumn("railways tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.railways),
                getColumn("airports tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.airports),
                getColumn("docks tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.docks),
                getColumn("vehicles tech", CURRENCY_PRECISE, c -> c.infrastructure.infrastructureTechnology.vehicles),
                getColumn("roads fund", PERCENT, c -> c.infrastructure.infrastructureFunding.roads),
                getColumn("highways fund", PERCENT, c -> c.infrastructure.infrastructureFunding.highways),
                getColumn("railways fund", PERCENT, c -> c.infrastructure.infrastructureFunding.railways),
                getColumn("airports fund", PERCENT, c -> c.infrastructure.infrastructureFunding.airports),
                getColumn("docks fund", PERCENT, c -> c.infrastructure.infrastructureFunding.docks),
                getColumn("vehicles fund", PERCENT, c -> c.infrastructure.infrastructureFunding.vehicles),
                getColumn("housing units", SIMPLE, c -> c.improvementsToLand.housingUnits));
    }
}
