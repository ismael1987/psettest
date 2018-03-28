package at.problemtest.problemtest.pset2.controller;


import at.problemtest.problemtest.pset2.model.Move;
import at.problemtest.problemtest.pset2.view.Judge;

public class Game {
    private PlayerHotel playerHotel = new PlayerHotel();
    public void play() {
        Players player1 = playerHotel.getHumman();
        Players player2 = playerHotel.getComputer();
        Moves moves = new Moves();
        Move move1= player1.getMove(moves);
        Move move2 = player2.getMove(moves);
        Judge judge = new Judge();
        judge.sayResult(move1, move2);

    }
}
