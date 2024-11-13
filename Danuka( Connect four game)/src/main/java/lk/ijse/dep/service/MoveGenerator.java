/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.dep.service;

import java.util.ArrayList;
import java.util.List;

/**
   Author: Darwin Díaz González.
 */

public class MoveGenerator {

    private final BoardImpl board;
    private final MoveValidator moveValidator;
    
    public MoveGenerator(BoardImpl board) {
        this.board = board;
        this.moveValidator = new MoveValidator(board);
    }
    
    public List<BoardImpl> getAllLegalNextMoves(Piece currentPiece) {
        Piece nextPiece = (currentPiece == Piece.BLUE) ? Piece.GREEN : Piece.BLUE;
        List<BoardImpl> nextMoves = new ArrayList<>();
        
        for (int col = 0; col < Board.NUM_OF_COLS; col++) {
            if (moveValidator.findNextAvailableSpot(col) > -1) {
                // Crear una nueva instancia usando el constructor que acepta el array de piezas
                BoardImpl legalMove = new BoardImpl(board.getPieces(), board.getBoardUI());
                legalMove.piece = nextPiece; // Importante: establecer la pieza actual
                legalMove.updateMove(col, nextPiece);
                nextMoves.add(legalMove);
            }
        }
        return nextMoves;
    }
    
    public BoardImpl getRandomLegalNextMove(Piece currentPiece) {
        List<BoardImpl> legalMoves = getAllLegalNextMoves(currentPiece);
        if (legalMoves.isEmpty()) {
            return null;
        }
        return legalMoves.get(Board.RANDOM_GENERATOR.nextInt(legalMoves.size()));
    }

}
