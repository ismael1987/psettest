package at.problemtest.problemtest.pset2.view;



import at.problemtest.problemtest.pset2.model.Move;
import at.problemtest.problemtest.pset2.model.Paper;
import at.problemtest.problemtest.pset2.model.Rock;
import at.problemtest.problemtest.pset2.model.Scissors;

import java.util.HashMap;

public class Judge {
    private HashMap<String,String> hashmap;
    public Judge(){
        hashmap = new HashMap<>();
        hashmap.put(Rock.class.getSimpleName(), Scissors.class.getSimpleName());
        hashmap.put(Scissors.class.getSimpleName(), Paper.class.getSimpleName());
        hashmap.put(Paper.class.getSimpleName(), Rock.class.getSimpleName());
    }
    public String sayResult(Move move1, Move move2) {
        System.out.println("The Player1 move: " + move1.getName());
        System.out.println("The Computer move: " + move2.getName());
        if (move1.getName().equalsIgnoreCase(move2.getName())){
            System.out.println("Draw");
            return "Draw";
        }
        String winningMove = hashmap.get(move1.getName());
        if (winningMove.equalsIgnoreCase(move2.getName())){
            System.out.println("Player1 wins");
            return "Player1 wins";
        }
        System.out.println("Computer wins");
        return "Computer wins";
    }

}
