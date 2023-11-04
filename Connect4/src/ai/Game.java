/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author arafa
 */
public class Game {
    private GameBoard board;
    private String color1;
    private String color2;
    public Circles[] [] boar(){
        return board.getOurBoard();
    
}
    public void setIs1playing(boolean is1playing) {
        this.is1playing = is1playing;
    }
    private boolean is1playing;
  //////////////////////////////////////////////////////////////////////////////////////
    public boolean isIs1playing() {
        return is1playing;
    }
  //////////////////////////////////////////////////////////////////////////////////////
    public Game(String color1, String color2, int rows, int columns) {
        this.board = new GameBoard(rows, columns);
        this.color1 = color1;
        this.color2 = color2;
        is1playing = (new Random()).nextBoolean();
    }
  //////////////////////////////////////////////////////////////////////////////////////
    public int PlayerTone(int col) {
        String color = is1playing ? color1 : color2;
        int row = board.addCircle(col, color);
        if(row != -1) is1playing = !is1playing;
        return row;
    }
  //////////////////////////////////////////////////////////////////////////////////////
    public boolean checkForWinnerInGUI(int column) {
        String winningColor;
       // JOptionPane.showMessageDialog(null, "color1="+color1+",,, color2= "+color2);
 
        if(!is1playing) {
          //  JOptionPane.showMessageDialog(null, "!1playing ,,, color1");
            winningColor = color1;
        } else {
           // JOptionPane.showMessageDialog(null, "1playing ,,, color2");
            winningColor = color2;
        }
        return checkForWinner(column, winningColor);
    }
  ///////////////////////////////////////////////////////////////////////////////////////
      private boolean checkDiagonal(int row, int col, String winningColor, boolean rightDiagonal) {
        int winningStreak = 4;
        int reverser = rightDiagonal ? 1 : -1;
        int rows = 6;
        int columns = 7;
        Circles[][] ourBoard = board.getOurBoard();

        for(int winRow = row - 3, winCol = col - (3 * reverser); winRow <= row + 3; winRow++, winCol += reverser) {
            if (!rightDiagonal) {
                if (winRow < 0 || winCol < 0) continue;
                if (winRow >= rows || winCol >= columns) break;
            } else {
                if(winRow < 0 || winCol >= columns) continue;
                if(winRow >= rows || winCol < 0) break;
            }

            if(ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getColor().equals(winningColor)) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }
  //////////////////////////////////////////////////////////////////////////////////////
    public boolean checkForWinner(int col, String winningColor) {
        int rows = 6;
        int columns = 7;
        Circles[][] ourBoard = board.getOurBoard();

        for(int row = 0; row < rows; row++) {
            if(ourBoard[row][col] != null) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                    if(ourBoard[winRow][col].getColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 3;
                }

                winningStreak = 4;
                // look at the horizontal
                for(int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;

                    if(ourBoard[row][winCol] != null && ourBoard[row][winCol].getColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 4;
                }
                if(checkDiagonal(row, col, winningColor, false)) return true;
                if(checkDiagonal(row, col, winningColor, true)) return true;

                return false;
            }
        }
        return false;
    }
 //////////////////////////////////////////////////////////////////////////////////////
  public void reset(int rows, int columns) {
        this.board = new GameBoard(rows, columns);
        is1playing = (new Random()).nextBoolean();
    }   
}
