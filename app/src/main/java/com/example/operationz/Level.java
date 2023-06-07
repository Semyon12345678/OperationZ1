package com.example.operationz;

public class Level {
    int quantity;
    Room[] rooms = new Room[2];

    public Level( Room[] rooms) {
        this.rooms = rooms;
    }
}
