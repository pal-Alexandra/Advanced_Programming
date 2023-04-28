package org.homework.map;

/**
 * @author Pal Alexandra
 * This class describes a cell of the matrix: a location of the map.
 * Every cell contains a list of tokens (this list is null at the beggining, and will be filled by the concurrent robots).
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class Cell {
    private List<Token> tokensFromCell;

    public Cell() {
        tokensFromCell = new ArrayList<>();
    }

    public Cell(List<Token> tokensFromCell) {
        this.tokensFromCell = tokensFromCell;
    }


    /**
     * This method return how many tokens are in the current cell.
     *
     * @return: 0 if the cell is empty, >0 otherwise.
     */
    public int getSize() {
        return this.tokensFromCell.size();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokensFromCell=" + tokensFromCell +
                '}';
    }
}
