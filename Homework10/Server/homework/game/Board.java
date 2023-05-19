package org.homework.game;

/**
 * @author Pal Alexandra
 * This class describes the board of a TIC TAC TOE game
 */
public class Board {

    private char[][] board;
    private static final int SIZE = 4;
    private static final char EMPTY = ' ';
    private static final char[] SYMBOLS = {'X', 'O'};

    public Board() {
        board = new char[SIZE][SIZE];
        clear();
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean isFull() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    /**
     * This method checks if a row was formed with the given symbol
     *
     * @param symbol
     * @return
     */
    private boolean checkRows(char symbol) {
        for (int i = 1; i < SIZE; i++) {
            if (board[i][1] == symbol && board[i][1] == board[i][2] && board[i][1] == board[i][3]) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if a column was formed with the given symbol
     *
     * @param symbol
     * @return
     */
    private boolean checkColumns(char symbol) {
        for (int j = 1; j < SIZE; j++) {
            if (board[1][j] == symbol && board[1][j] == board[2][j] && board[1][j] == board[3][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if a diagonal was formed with the given symbol
     *
     * @param symbol
     * @return
     */
    private boolean checkDiagonals(char symbol) {
        if (board[1][1] == symbol && board[1][1] == board[2][2] && board[1][1] == board[3][3]) {
            return true;
        }
        if (board[1][3] == symbol && board[1][3] == board[2][2] && board[1][3] == board[3][1]) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the position is within the board and the position has no symbol in it.
     *
     * @param row
     * @param column
     * @return
     */
    public boolean isValidMove(int row, int column) {
        boolean isValidRow = row >= 1 && row <= 3;
        boolean isValidColumn = column >= 1 && column <= 3;
        return isValidRow && isValidColumn && board[row][column] == EMPTY;
    }

    public void makeMove(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-------------\n");
        for (int i = 1; i < SIZE; i++) {
            sb.append("| ");
            for (int j = 1; j < SIZE; j++) {
                sb.append(board[i][j]).append(" | ");
            }
            sb.append("\n");
            sb.append("-------------\n");
        }
        return sb.toString();
    }


}
