/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import javax.swing.JOptionPane;

/**
 *
 * @author arafa
 */
public class GameBoard {
     private int rows;
    private int columns;

    Circles [][]ourBoard;

     Circles[][] getOurBoard() {
        return ourBoard;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
    public int addCircle(int colToAdd, String color) {
        // within normal range
        if(colToAdd >= 0 && colToAdd < columns) {
            // we can add
            if(ourBoard[0][colToAdd] == null) {
                boolean addedThePiece = false;
                int addedRow = -1;
                for(int row = rows - 1; row >= 0; row--)
                    if(ourBoard[row][colToAdd] == null) {
                        ourBoard[row][colToAdd] = new Circles();
                        ourBoard[row][colToAdd].setColor(color);
                        addedThePiece = true;
                        addedRow = row;
                        break;
                    }
                return addedRow;
            } else {
                JOptionPane.showMessageDialog(null,"This row is full , please choose else");
                return -1;
            }
        } else {
          
            return -1;
        }
    }

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        ourBoard = new Circles[rows][columns];
        for(int row = 0; row < rows; row++)
            for(int col = 0; col < columns; col++)
                ourBoard[row][col] = null;
    }

    
}
