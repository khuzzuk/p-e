package pl.projectE.ui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import pl.projectE.App;
import pl.projectE.ui.controllers.MainWindowController;
import pl.projectE.ui.controllers.TaxViewController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainWindowStage extends Stage {
    private Map<Class<?>, Initializable> controllers;

    public MainWindowStage() {
        super(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);

        TaxViewController taxViewController = new TaxViewController();
        MainWindowController mainWindowController = new MainWindowController();
        mainWindowController.taxViewController = taxViewController;

        controllers = new HashMap<>();
        controllers.put(MainWindowController.class, mainWindowController);
        controllers.put(TaxViewController.class, taxViewController);
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
