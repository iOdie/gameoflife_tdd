package org.gameOfLife;

public class GameBoard {

    private final int height;
    private final int width;
    private final FieldType[][] board;

    public GameBoard () {
        this.height = 10;
        this.width = 10;
        this.board = new FieldType[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = FieldType.UNALIVE;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public FieldType getField(int x, int y) {
        return board[x][y];
    }

    public void setField(FieldType fieldType, int x, int y) {
        board[x][y] = fieldType;
    }

    public FieldType[] getNeigbors(int x, int y) {
        // x 0 0
        // 0 _ 0
        // 0 0 x
        FieldType[] neighbors = new FieldType[8];
        neighbors[0] = board[0][0];
        neighbors[1] = board[1][0];
        neighbors[2] = board[2][0];

        neighbors[3] = board[0][1];
        neighbors[4] = board[2][1];

        neighbors[5] = board[0][2];
        neighbors[6] = board[1][2];
        neighbors[7] = board[2][2];
        return neighbors;
    }
}
