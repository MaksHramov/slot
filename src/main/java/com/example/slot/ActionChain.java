package com.example.slot;

import java.util.Random;

public class ActionChain {

    public static final int SUCCESS = 1;
    public static final int CHANCE = 2;
    public static final int LOSS = 3;

    Handler chain;

    Random generate;

    final int NUMHANDLER = 4;

    public ActionChain() {
        generate = new Random();
        buildChain();
    }

    private void buildChain() {
        chain =
                new NegativeHandler(
                        new ChanceHandler(
                                new PositiveHandler(null)
                        )
                );
    }

    public int playRound() {
        int outcome = 1 + generate.nextInt(3);
        chain.process(outcome);
        return outcome;
    }

    public boolean process(Integer a) {

        return chain.process(1 + a % NUMHANDLER);
    }
}