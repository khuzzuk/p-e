package pl.projectE.ui.tables;

import javafx.scene.control.TableView;
import pl.projectE.model.Country;
import pl.projectE.ui.ColumnFactory;

import static pl.projectE.ui.ValueFormatter.PERCENT;
import static pl.projectE.ui.ValueFormatter.SIMPLE;

public class EducationTableView extends TableView<Country> implements ColumnFactory<Country> {
    public EducationTableView() {
        getColumns().addAll(getColumnWithString("country", c -> c.name),
                getColumn("numberOfEducationalDays", SIMPLE, c -> c.education.numberOfEducationalDays),
                getColumn("numberOfChildInGroups", SIMPLE, c -> c.education.numberOfChildInGroups),
                getColumn("teachersSalary", PERCENT, c -> c.education.teachersSalary),
                getColumn("plannedStudents", PERCENT, c -> c.education.plannedStudents),
                getColumn("fundingResearch", PERCENT, c -> c.education.fundingResearch),
                getColumn("researchEquipmentFunding", PERCENT, c -> c.education.researchEquipmentFunding),
                getColumn("naturalResourcesFunding", PERCENT, c -> c.education.naturalResourcesFunding),
                getColumn("biomedicsFunding", PERCENT, c -> c.education.biomedicsFunding),
                getColumn("engineeringFunding", PERCENT, c -> c.education.engineeringFunding),
                getColumn("computersFunding", PERCENT, c -> c.education.computersFunding),
                getColumn("mathematicsEconomyFunding", PERCENT, c -> c.education.mathematicsEconomyFunding),
                getColumn("physicsFunding", PERCENT, c -> c.education.physicsFunding),
                getColumn("socialSciencesFunding", PERCENT, c -> c.education.socialSciencesFunding),
                getColumn("militaryFunding", PERCENT, c -> c.education.militaryFunding),
                getColumn("humanitiesFunding", PERCENT, c -> c.education.humanitiesFunding),
                getColumn("foreignLanguagesFunding", PERCENT, c -> c.education.foreignLanguagesFunding),
                getColumn("artistryFunding", PERCENT, c -> c.education.artistryFunding)
        );
    }
}
