/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.dep.service;

/**
   Author: Darwin Díaz González.
 */

public class MoveValidator {
    
    private final BoardImpl board;
    
    public MoveValidator(BoardImpl board){
        this.board = board;
    }
    
    public int findNextAvailableSpot(int col){
        for(int i = 0; i < BoardImpl.NUM_OF_ROWS; i++){
            if(board.getPiece(col, i) == Piece.EMPTY){
                return i;
            }
        }
        return -1;
    }
    
    public boolean isLegalMove(int col){
        return findNextAvailableSpot(col) > -1;
    }
    
    public boolean existLegalMoves(){
        for (int i = 0; i < BoardImpl.NUM_OF_COLS; i++){
            if(isLegalMove(i)){
                return true;
            }
        }
        return false;
    }
    
}
