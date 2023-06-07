package com.example.operationz;

public class Hero{
    int x = 3;
    int y = 3;
    int hp = 1;
    public void go(int direction, int blockHeight, int blockWidth, int[][] room) throws InterruptedException {

        if(direction == 1){
            if(y>0) {
                if (y > 0 && y % blockHeight != 0) {
                    y--;
                } else if (y % blockHeight == 0) {
                    if (room[y / blockHeight - 1][x / blockWidth] == 0 && room[y / blockHeight - 1][(x + blockWidth) / blockWidth] == 0) {
                        y--;
                    }
                }
                //else if(y==1 && x==blockWidth*21-1) g = 2;
            }
        }




        if(direction == 2) {
            if(x + blockWidth != blockWidth * 22){
            if (x + blockWidth != blockWidth * 22 && x % blockWidth != 0) {
                x++;
            } else if (x % blockWidth == 0) {
                if (room[y / blockHeight][x / blockWidth + 1] == 0 && room[(y + blockHeight) / blockHeight][x / blockWidth + 1] == 0) {
                    x++;
                }
            }
           // else if(x>blockWidth*20) g = 2;

        }
        }



        if(direction == 3) {
            if(y + blockHeight != blockHeight * 10){
            if (y + blockHeight != blockHeight * 10 && y % blockHeight != 0) {
                y++;
            } else if (y % blockHeight == 0) {
                if (room[y / blockHeight + 1][x / blockWidth] == 0 && room[y / blockHeight + 1][(x + blockWidth) / blockWidth] == 0) {
                    y++;
                }
            }
        }
        }



        if(direction == 4) {
            if(x > 0){
            if (x > 0 && x % blockWidth != 0) {
                x--;
            } else if (x % blockWidth == 0) {
                if (room[y / blockHeight][x / blockWidth - 1] == 0 && room[(y + blockHeight) / blockHeight][x / blockWidth - 1] == 0) {
                    x--;
                }
            }
        }
        }
    }

}
