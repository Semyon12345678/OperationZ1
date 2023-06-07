package com.example.operationz;

import java.util.Random;

public class Enemy {

    int x = 1500;
    int heroHP = 1;
    int y = 500;
    Random random = new Random();
    int hp = 1;
    int direction = 1;



    public void go(int blockHeight, int blockWidth, int[][] room, int heroX, int heroY) throws InterruptedException {
    if(direction == 1){
        if(heroX==x && heroY<y) heroHP = 0;
        else if(heroX==x && heroY-y<2) hp = 0;
        //else if (heroY==y && x-heroX<2) hp = 0;
        //else if (heroX==x && y-heroY<2) hp = 0;
        //else if (heroY==y && heroX-x<2) hp = 0;

        if(y>0) {
//            if (y > 0 && y % blockHeight != 0) {
//                y--;
//            } else if (y % blockHeight == 0) {
//                if (room[y / blockHeight - 1][x / blockWidth] == 0 && room[y / blockHeight - 1][(x + blockWidth) / blockWidth] == 0) {
//                    y--;
//                }
  //      }
            y--;

            //else if(y==1 && x==blockWidth*21-1) g = 2;
        }
        else direction = random.nextInt(4);
    }




        if(direction == 2) {
            if(heroY==y && heroX>x) heroHP = 0;
            //else if(heroX==x && heroY-y<2) hp = 0;
            else if (heroY==y && x-heroX<2) hp = 0;
            //else if (heroX==x && y-heroY<2) hp = 0;
            //else if (heroY==y && heroX-x<2) hp = 0;

        if(x + blockWidth != blockWidth * 22){
//            if (x + blockWidth != blockWidth * 22 && x % blockWidth != 0) {
//                x++;
//            } else if (x % blockWidth == 0) {
//                if (room[y / blockHeight][x / blockWidth + 1] == 0 && room[(y + blockHeight) / blockHeight][x / blockWidth + 1] == 0) {
//                    x++;
//                }
//            }
            // else if(x>blockWidth*20) g = 2;
            x++;

        }
        else direction = random.nextInt(4);
    }



        if(direction == 3) {
            if(heroX==x && heroY>y) heroHP = 0;
            //else if(heroX==x && heroY-y<2) hp = 0;
            //else if (heroY==y && x-heroX<2) hp = 0;
            else if (heroX==x && y-heroY<2) hp = 0;
            //else if (heroY==y && heroX-x<2) hp = 0;

        if(y + blockHeight != blockHeight * 10){
//            if (y + blockHeight != blockHeight * 10 && y % blockHeight != 0) {
//                y++;
//            } else if (y % blockHeight == 0) {
//                if (room[y / blockHeight + 1][x / blockWidth] == 0 && room[y / blockHeight + 1][(x + blockWidth) / blockWidth] == 0) {
//                    y++;
//                }
//            }
            y++;
        }
        else direction = random.nextInt(4);
    }



        if(direction == 4) {
            if(heroY==y && heroX<x) heroHP = 0;
            //else if(heroX==x && heroY-y<2) hp = 0;
            //else if (heroY==y && x-heroX<2) hp = 0;
            //else if (heroX==x && y-heroY<2) hp = 0;
            else if (heroY==y && heroX-x<2) hp = 0;

        if(x > 0){
//            if (x > 0 && x % blockWidth != 0) {
//                x--;
//            } else if (x % blockWidth == 0) {
//                if (room[y / blockHeight][x / blockWidth - 1] == 0 && room[(y + blockHeight) / blockHeight][x / blockWidth - 1] == 0) {
//                    x--;
//                }
//            }
            x--;
        }
        else direction = random.nextInt(4);
    }
}
}

















