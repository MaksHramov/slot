package com.example.slot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Label balanceLabel;

    @FXML
    private Button playButton;

    private Player player =
            new Player("Игрок",0);

    private ActionChain action;

    private boolean afterChance;

    @FXML
    public void initialize() {
        updateBalance();
    }

    @FXML
    public void onPay(){

        player.addNumber(1);

        System.out.println("Монетка добавлена");

        updateBalance();

    }

    @FXML
    public void onPlay(){

        if(!init()){

            return;

        }

        action = new ActionChain();

        afterChance = false;

        openBagWindow();

        playButton.setDisable(true);

        updateBalance();

    }

    public void handleOutcome(int outcome, Stage bagStage) {

        switch (outcome) {
            case ActionChain.SUCCESS -> {
                player.addNumber(2);
                bagStage.close();
                playButton.setDisable(false);
                action = null;
                afterChance = false;
            }
            case ActionChain.LOSS -> {
                if (afterChance) {
                    player.addNumber(-1);
                }
                bagStage.close();
                playButton.setDisable(false);
                action = null;
                afterChance = false;
            }
            case ActionChain.CHANCE -> {
                afterChance = true;
            }
        }

        updateBalance();

    }

    public boolean init(){

        if(!player.pay(1)){

            System.out.println(
                    "Недостаточно средств!"
            );

            action = null;

            return false;

        }

        updateBalance();

        return true;

    }

    private void openBagWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bag-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Выбор мешочка");
            stage.setScene(new Scene(loader.load(), 280, 220));
            BagController bagController = loader.getController();
            bagController.init(this, action, stage);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBalance() {
        if (balanceLabel != null) {
            balanceLabel.setText("Монетки: " + player.getNumber());
        }
    }

}
