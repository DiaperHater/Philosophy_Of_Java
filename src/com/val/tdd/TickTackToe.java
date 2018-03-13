package com.val.tdd;

public class TickTackToe {

    private Character[][] board = {
            {'\0','\0','\0'},
            {'\0','\0','\0'},
            {'\0','\0','\0'}
    };
    private char nextPlayer = 'X';
    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {

        checkAxis(x);
        checkAxis(y);
        setBox(x,y);
        nextPayer();

        if (isWin(x, y)){
            return String.format("Player %c is Winner!", lastPlayer);
        }else if (isDraw()){
            return "Draw!";
        }

        return "No winner";

    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++){
            for (int x = 0; x < SIZE; x++){
                if (board[i][x] == '\0'){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isWin(int x, int y){
        int playerTotal = lastPlayer * 3;
        char topBottom = '\0';
        char bottomTop = '\0';
        char vertical = '\0';
        char horizontal = '\0';


        for(int i = 0; i < SIZE; i++){
            horizontal += board[i][y-1];
            vertical += board[x-1][i];
            topBottom += board[i][i];
            bottomTop += board[i][SIZE - i - 1];
        }

        return topBottom == playerTotal ||
                bottomTop == playerTotal ||
                horizontal == playerTotal ||
                vertical == playerTotal;

    }

    private void setBox(int x, int y) {
        if(board[x-1][y-1] != '\0'){
            throw new RuntimeException("Box is occupied!");
        }else {
            board[x-1][y-1] = nextPlayer;
        }
    }

    private void checkAxis(int i) {
        if(i < 1 || i > 3){
            throw new RuntimeException("Outside the board");
        }
    }

    public char nextPayer() {

        if(nextPlayer == 'X'){
            nextPlayer = 'O';
            lastPlayer = 'X';
            return lastPlayer;
        }else {
            nextPlayer = 'X';
            lastPlayer = 'O';
            return lastPlayer;
        }

    }
}
