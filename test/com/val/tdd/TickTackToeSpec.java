package com.val.tdd;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TickTackToeSpec {
    private TickTackToe tickTackToe;

    @BeforeEach
    void beforeEach(){
        tickTackToe = new TickTackToe();
    }

    @Test
    void whenXOutSideBoardThenRuntimeException(){
        assertThrows(RuntimeException.class, ()->tickTackToe.play(5,2));
    }

    @Test
    void whenYOutSideBoardThenRuntimeException(){
        assertThrows(RuntimeException.class, ()->tickTackToe.play(2,5));
    }

    @Test
    void whenOccupiedThenRuntimeException(){
        tickTackToe.play(2,1);
        assertThrows(RuntimeException.class, ()->{tickTackToe.play(2, 1);});
    }

    @Test
    void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X', tickTackToe.nextPayer());
    }

    @Test
    void givenLastTurnWasXWhenNextPlayerThenO(){
        tickTackToe.play(1,1);
        assertEquals('O', tickTackToe.nextPayer());
    }

    @Test
    void whenPlayThenNoWinner(){
        assertEquals("No winner", tickTackToe.play(1,1));
    }

    @Test
    void whenPlayAndWholeHorizontalLineThenWinner(){
        tickTackToe.play(1,1); //player X
        tickTackToe.play(2,1);
        tickTackToe.play(1,2); //player X
        tickTackToe.play(2,2);
        String actual = tickTackToe.play(1,3); //player X

        assertEquals("Player X is Winner!", actual);
    }

    @Test
    void whenPlayAndWholeVerticalLineThenWinner(){
        tickTackToe.play(1,1); //player X
        tickTackToe.play(1,2); //player O
        tickTackToe.play(2,1); //player X
        tickTackToe.play(2,2); //player O
        tickTackToe.play(2,3); //player X
        String actual = tickTackToe.play(3,2); //player O

        assertEquals("Player O is Winner!", actual);
    }

    @Test
    void whenPlayAndTopBottomDiagonalLineThenWinner(){
        tickTackToe.play(1,1); //player X
        tickTackToe.play(1,2); //player O
        tickTackToe.play(2,2); //player X
        tickTackToe.play(1,3); //player O
        String actual  = tickTackToe.play(3,3); //player X

        assertEquals("Player X is Winner!", actual);
    }

    @Test
    void whenPlayAndBottomTopDiagonalLineThenWinner(){
        tickTackToe.play(1,3); //player X
        tickTackToe.play(1,2); //player O
        tickTackToe.play(2,2); //player X
        tickTackToe.play(1,1); //player O
        String actual  = tickTackToe.play(3,1); //player X

        assertEquals("Player X is Winner!", actual);
    }

    @Test
    void whenAllBoxesAreFilledThenDraw(){
        tickTackToe.play(1,1);
        tickTackToe.play(1,2);
        tickTackToe.play(1,3);
        tickTackToe.play(2,1);
        tickTackToe.play(2,3);
        tickTackToe.play(2,2);
        tickTackToe.play(3,1);
        tickTackToe.play(3,3);
        String actual = tickTackToe.play(3,2);

        assertEquals("Draw!", actual);

    }
}
