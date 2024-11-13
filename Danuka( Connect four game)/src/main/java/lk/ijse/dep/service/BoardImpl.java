package lk.ijse.dep.service;

import java.util.List;

public class BoardImpl extends Board {

    private final Piece[][] pieces;
    private final BoardUI boardUI;
    private final MoveValidator moveValidator;
    private final WinnerDetector winnerDetector;
    private final MoveGenerator moveGenerator;
    public Piece piece = Piece.BLUE;
    public int cols;
    
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        initializeBoard();
        
        this.moveValidator = new MoveValidator(this);
        this.winnerDetector = new WinnerDetector(this);
        this.moveGenerator = new MoveGenerator(this);
    }

    public BoardImpl(Piece[][] pieces, BoardUI boardUI) {
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            System.arraycopy(pieces[i], 0, this.pieces[i], 0, NUM_OF_ROWS);
        }
        this.boardUI = boardUI;
        this.moveValidator = new MoveValidator(this);
        this.winnerDetector = new WinnerDetector(this);
        this.moveGenerator = new MoveGenerator(this);
    }
    
    private void initializeBoard() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }
    
    public Piece[][] getPieces() {
        Piece[][] copy = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            System.arraycopy(pieces[i], 0, copy[i], 0, NUM_OF_ROWS);
        }
        return copy;
    }
    
    @Override
    public BoardUI getBoardUI() {
        return this.boardUI;
    }
    
    @Override
    public int findNextAvailableSpot(int col) {
        return moveValidator.findNextAvailableSpot(col);
    }
    
    @Override
    public boolean isLegalMove(int col) {
        return moveValidator.isLegalMove(col);
    }
    
    @Override
    public boolean existLegalMoves() {
        return moveValidator.existLegalMoves();
    }
    
    @Override
    public void updateMove(int col, Piece move) {
        this.cols = col;
        this.piece = move;
        
        int row = moveValidator.findNextAvailableSpot(col);
        if (row != -1) {
            pieces[col][row] = move;
        }
    }
    
    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }
    
    @Override
    public Winner findWinner() {
        return winnerDetector.findWinner();
    }
    
    @Override
    public BoardImpl getBoardImpl() {
        return this;
    }
    
    public boolean getStatus() {
        if (!existLegalMoves()) {
            return false;
        }
        Winner winner = findWinner();
        return winner.getWinningPiece() == Piece.EMPTY;
    }
    
    public List<BoardImpl> getAllLegalNextMoves() {
        return moveGenerator.getAllLegalNextMoves(this.piece);
    }
    
    public BoardImpl getRandomLegalNextMove() {
        return moveGenerator.getRandomLegalNextMove(this.piece);
    }
    
    public Piece getPiece(int col, int row) {
        return pieces[col][row];
    }
    
    public void setPiece(int col, int row, Piece piece) {
        pieces[col][row] = piece;
    }
    
}