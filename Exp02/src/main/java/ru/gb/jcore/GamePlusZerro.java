package ru.gb.jcore;

import java.util.Scanner;

//Game for you
public class GamePlusZerro {
    // Playing field size
    private static final byte poleSize = 3;
    //We set the field as a (!) one-dimensional array
    private static String[] pole = new String[poleSize * poleSize];

    //set the current player
    private static byte playerNumber = 0;

    // The function sets the number of the next player
    private static void nextPlayer() {
        playerNumber = (byte) (1 == playerNumber ? 2 : 1);
    }

    /*
     * Determining whether the game is over or not
     * Conditions:
     * 1) The crosses won
     * 2) The zeroes won
     * 3) Out of moves
     */
    private static boolean gameEnd() {
        int i, j;
        boolean rowWin = false, colWin = false;

        // Checking victory on columns and columns
        for (i = 0; i < poleSize; i++) {
            rowWin = true;
            colWin = true;
            for (j = 0; j < poleSize - 1; j++) {
                rowWin &= (getXY(i, j).charAt(0) == getXY(i, j + 1).charAt(0));
                colWin &= (getXY(j, i).charAt(0) == getXY(j + 1, i).charAt(0));
            }
            if (colWin || rowWin) {
                System.out.println("The player wins" + playerNumber);
                return true;
            }
        }




}