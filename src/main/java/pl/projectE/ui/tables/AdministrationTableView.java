package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;

public class AdministrationTableView extends TableView<Country> implements ColumnFactory<Country> {
    public AdministrationTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("officials rate", PERCENT, c -> c.administration.officialsProjectedRate),
                getColumn("officials salary", PERCENT, c -> c.administration.officialsSalary),
                getColumn("police", PERCENT, c -> c.administration.justice.policeOfficersProjected),
                getColumn("salary", PERCENT, c -> c.administration.justice.policeOfficersSalary),
                getColumn("equipment", PERCENT, c -> c.administration.justice.policeEquipmentFunding),
                getColumn("judges", PERCENT, c -> c.administration.justice.courtSupplyingJudge),
                getColumn("salary", PERCENT, c -> c.administration.justice.courtJudgeSalary),
                getColumnWithEnum("emigration", c -> c.administration.laws.emigrationPolicy),
                getColumnWithEnum("immigration", c -> c.administration.laws.immigrationPolicy),
                getColumnWithEnum("assimilation", c -> c.administration.laws.assimilation),
                getColumnWithBoolean("fair trial", c -> c.administration.laws.rightToFairTrial),
                getColumnWithBoolean("supreme court", c -> c.administration.laws.freeSupremeCourt),
                getColumnWithBoolean("district court", c -> c.administration.laws.freeDistrictCourts),
                getColumnWithBoolean("speech", c -> c.administration.laws.freeSpeech),
                getColumnWithBoolean("press", c -> c.administration.laws.freePress),
                getColumnWithBoolean("internet", c -> c.administration.laws.freeInternet),
                getColumnWithBoolean("access to edu", c -> c.administration.laws.freeAccessToEducation),
                getColumnWithBoolean("libraries", c -> c.administration.laws.nationalLibrarySystem),
                getColumnWithBoolean("ids", c -> c.administration.laws.personalId),
                getColumnWithBoolean("heavy ids", c -> c.administration.laws.oppressedDocumentVerification),
                getColumnWithBoolean("tax invest.", c -> c.administration.laws.taxInvestigations),
                getColumnWithBoolean("heavy weapons", c -> c.administration.laws.heavyWeaponsForPolice),
                getColumnWithBoolean("religious tolerance", c -> c.administration.laws.religiousTolerance),
                getColumnWithBoolean("tolerate intolerant", c -> c.administration.laws.tolerateIntolerant)
        );
    }
}
