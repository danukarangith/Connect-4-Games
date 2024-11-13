
package lk.ijse.dep.service;

public interface BoardState {
    int findNextAvailableSpot(int col);
    boolean isLegalMove(int col);
    boolean existLegalMoves();
    void updateMove(int col, Piece move);
    void updateMove(int col, int row, Piece move);
}
