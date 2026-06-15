package com.example.slot;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NegativeHandler extends Handler {

    public NegativeHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {

        if(request != ActionChain.LOSS){
            return super.process(request);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Проигрыш");
        alert.setHeaderText("Монеток нет!");
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();

        return true;

    }
}
