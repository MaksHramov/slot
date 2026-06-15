package com.example.slot;

import javafx.scene.control.Alert;

public class ChanceHandler extends Handler {

    public ChanceHandler(Handler processor) {
        super(processor);
    }

    @Override
    public boolean process(Integer request) {

        if(request != ActionChain.CHANCE){
            return super.process(request);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Шанс");

        alert.setHeaderText(
                "Вы проиграли!\nНо судьба дает Вам шанс сыграть бесплатно!"
        );

        alert.showAndWait();

        return true;

    }

}