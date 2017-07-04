package pl.projectE.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.projectE.App;
import pl.projectE.ui.controllers.Formatted;
import pl.projectE.ui.controllers.MainWindowController;
import pl.projectE.ui.controllers.PopulationViewController;
import pl.projectE.ui.controllers.TaxViewController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainWindowStage extends Stage {
    private Map<Class<? extends Formatted>, Formatted> controllers;

    public MainWindowStage() {
        super(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);

        MainWindowController mainWindowController = new MainWindowController();

        controllers = new HashMap<>();
        controllers.put(MainWindowController.class, mainWindowController);
        controllers.put(TaxViewController.class, new TaxViewController());
        controllers.put(PopulationViewController.class, new PopulationViewController());
        mainWindowController.controllers = controllers;
    }

    public void init(Stage parent) {
        initOwner(parent);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainWindow.fxml"));
        loader.setControllerFactory(c -> controllers.get(c));
        try {
            setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        show();
        setOnCloseRequest(e -> App.bus.send("closeBus"));
    }
}
