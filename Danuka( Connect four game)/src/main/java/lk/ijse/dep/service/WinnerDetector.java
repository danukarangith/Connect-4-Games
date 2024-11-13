/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.dep.service;

/**
   Author: Darwin Díaz González.
 */

public class WinnerDetector {
    
    private final BoardImpl board;
    
    public WinnerDetector(BoardImpl board){
        this.board = board;
    }
    
    public Winner findWinner() {
        Winner verticalWinner = checkVertical();
        if (verticalWinner != null) return verticalWinner;
        Winner horizontalWinner = checkHorizontal();
        if (horizontalWinner != null) return horizontalWinner;
        return new Winner(Piece.EMPTY);
    }
    
    private Winner checkVertical() {
        for (int col = 0; col < BoardImpl.NUM_OF_COLS; col++) {
            for (int row = 0; row < BoardImpl.NUM_OF_ROWS - 3; row++) {
                Winner winner = checkLine(col, row, 0, 1);
                if (winner != null) return winner;
            }
        }
        return null;
    }
    
    private Winner checkHorizontal() {
        for (int col = 0; col < BoardImpl.NUM_OF_COLS - 3; col++) {
            for (int row = 0; row < BoardImpl.NUM_OF_ROWS; row++) {
                Winner winner = checkLine(col, row, 1, 0);
                if (winner != null) return winner;
            }
        }
        return null;
    }
    
    private Winner checkLine(int startCol, int startRow, int deltaCol, int deltaRow) {
        Piece currentPiece = board.getPiece(startCol, startRow);
        if (currentPiece == Piece.EMPTY) return null;
        
        for (int i = 1; i < 4; i++) {
            if (board.getPiece(startCol + deltaCol * i, startRow + deltaRow * i) != currentPiece) {
                return null;
            }
        }
        
        return new Winner(currentPiece, startCol, startRow, 
                         startCol + deltaCol * 3, startRow + deltaRow * 3);
    }

}
