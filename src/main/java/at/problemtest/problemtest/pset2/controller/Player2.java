package at.problemtest.problemtest.pset2.controller;


import at.problemtest.problemtest.pset2.model.Move;

import java.util.Collections;
import java.util.List;

public class Player2 implements Players {
    @Override
    public Move getMove(Moves move) {
        return coumpterMove(move);
    }

    private Move coumpterMove(Moves moves) {

        List<Move> move = moves.getMoves();
        Collections.shuffle(move);

        return move.get(0);
    }
}
