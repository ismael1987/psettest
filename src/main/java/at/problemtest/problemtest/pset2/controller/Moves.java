package at.problemtest.problemtest.pset2.controller;


import at.problemtest.problemtest.pset2.model.Move;
import at.problemtest.problemtest.pset2.model.Paper;
import at.problemtest.problemtest.pset2.model.Rock;
import at.problemtest.problemtest.pset2.model.Scissors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Moves {
    private List<Move> moves ;

    public Moves() {
        moves = Stream.of(
                new Paper(),
                new Rock(),
                new Scissors()
        )
                .collect(Collectors.toList());
    }

    public List<Move> getMoves() {
        return new ArrayList<>(moves);
    }
}
