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

        if (isWin()){
            return String.format("Player %c is Winner!", lastPlayer);
        }

        return "No winner";

    }

    private boolean isWin(){
        for(int i = 0; i < SIZE; i++){
            if(board[i][0] + board[i][1] + board[i][2] == (lastPlayer * SIZE)){
                return true;
            }
        }

        for(int i = 0; i < SIZE; i++){
            if(board[0][i] + board[1][i] + board[2][i] == (lastPlayer * SIZE)){
                return true;
            }
        }

        return false;
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
