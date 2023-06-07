package com.example.operationz;

public class Room {
    int[][] blocks = new int[10][22];
    int blockHeight;
    int blockWidth;

    public Room(int blockHeight, int blockWidth) {
        this.blockHeight = blockHeight;
        this.blockWidth = blockWidth;

    }

    public int[] getBlockCoordinates (int blockI, int blockJ){
        int[] blockXY = new int[2];
        blockXY[0] = blockJ*blockWidth;
        blockXY[1] = blockI*blockHeight;
        return blockXY;
    }

}
