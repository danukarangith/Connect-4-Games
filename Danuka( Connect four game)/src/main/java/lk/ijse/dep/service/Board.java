
package lk.ijse.dep.service;

import java.util.Random;

public abstract class Board implements BoardState, WinnerDetection, BoardUIHandler {
    protected static final int NUM_OF_ROWS = 5;
    protected static final int NUM_OF_COLS = 6;
    protected static final Random RANDOM_GENERATOR = new Random();

    // Abstract method to be implemented by subclasses
    public abstract BoardImpl getBoardImpl();
}
