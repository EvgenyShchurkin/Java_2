package com.lesson1.homework;

import java.util.Random;

public class Wall implements Obstacle{
    int wallHeight;

    public Wall() {
        this.wallHeight = new Random().nextInt(5);
    }

    public void getOver(Participant participant) {
        participant.jump(this.wallHeight);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "wallHeight=" + wallHeight +
                '}';
    }
}
