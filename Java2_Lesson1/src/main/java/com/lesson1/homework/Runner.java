package com.lesson1.homework;

import java.util.Random;

public class Runner implements Obstacle{
    int runLength;

    public Runner() {
        this.runLength = new Random().nextInt(800);
    }

    public void getOver(Participant participant) {
        participant.run(this.runLength);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "length=" + runLength +
                '}';
    }
}
