package org.compulsory;

/**
 * @author Pal Alexandra
 * This class descries the map that is explored by the robots.
 */

import java.util.List;

public class ExplorationMap {

    private final Cell[][] matrix;

    public ExplorationMap(Cell[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * This method is used to visit a new cell o the matrix, by a robot.
     *
     * @param row:   the row of the cell to be visited
     * @param col:   the column of the cell to bi visited
     * @param robot: the robot that wants to visit the cell
     * @return: true if the cell can be visited, (a cell can be visited if it doesn't contain any tokens), false otherwise.
     * If the cell can be visited, then the robot will extract some tokens from the shared memory, and will store them in the matrix cell.
     */
    public boolean visit(int row, int col, Robot robot) {

        synchronized (matrix[row][col]) {
            if (this.matrix[row][col].getSize() == 0) {
                List<Token> extractedTokens = robot.explore.getSharedMemory().extractTokens(5);
                System.out.println(robot.getName() + "a extras: " + extractedTokens.toString());
                var updateCell = new Cell(extractedTokens);
                matrix[row][col] = updateCell;
                return true;
            } else {
                return false;
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    /**
     * This method is used to check if every cell of the matrix contains any tokens.
     *
     * @return: true if every cell of the matrix contains any tokens, false otherwise.
     */
    public boolean isComplet() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j].getSize() == 0) {
                    return false;
                }
        }
        return true;
    }

    @Override
    public String toString() {
        System.out.println("The matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j].toString());
            }
            System.out.println("\n");
        }
        return " ";
    }
}
