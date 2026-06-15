package com.example.slot;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class PositiveHandler extends Handler {

    public PositiveHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {

        if(request != ActionChain.SUCCESS){
            return super.process(request);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Выигрыш");
        alert.setHeaderText("Вы нашли мешочек с монетами!");
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();

        return true;

    }
}
