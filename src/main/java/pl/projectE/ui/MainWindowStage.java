package pl.projectE.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainWindowStage extends Stage {
    public MainWindowStage() {
        super(StageStyle.DECORATED);
        initModality(Modality.WINDOW_MODAL);
    }

    public void init(Stage parent) {
        initOwner(parent);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainWindow.fxml"));
        try {
            setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        show();
    }
}
