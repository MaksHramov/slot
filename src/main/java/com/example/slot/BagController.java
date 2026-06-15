package com.example.slot;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class BagController {

    private Controller mainController;
    private ActionChain action;
    private Stage stage;

    public void init(Controller mainController, ActionChain action, Stage stage) {
        this.mainController = mainController;
        this.action = action;
        this.stage = stage;
    }

    @FXML
    public void onBag() {
        int outcome = action.playRound();
        mainController.handleOutcome(outcome, stage);
    }
}
