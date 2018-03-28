package at.problemtest.problemtest.pset2.view;


import at.problemtest.problemtest.pset2.model.Move;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class JudgeTest {


    private HashMap<String,String> hashmap;
        Judge judge = new Judge();
        Move move1;
        Move move2;

        @BeforeEach
        public void initialize() {

            Move move1 = mock(Move.class);
            Move move2 = mock(Move.class);

        }

    @Test
    public void Draw() {
          Mockito.when(hashmap.get(move1.getName().equalsIgnoreCase(move2.getName()))).thenReturn(String.valueOf(true));
           judge.sayResult(move1,move2);
            assertEquals("Draw",judge.sayResult(move1,move2));
    }
    @Test
    public void testMove1wins() {
        String winningMove = hashmap.get(move1.getName());
        Mockito.when(hashmap.get(winningMove.equalsIgnoreCase(move2.getName()))).thenReturn(String.valueOf(true));
        judge.sayResult(move1,move2);
        assertEquals("Player 1 wins",judge.sayResult(move1,move2));
    }






}