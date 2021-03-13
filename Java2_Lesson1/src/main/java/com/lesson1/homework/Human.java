package com.lesson1.homework;

public class Human implements Participant{
    String name;
    int height;
    int length;
    boolean isActive;

    public Human(String name, int height, int length) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.isActive=true;
    }

    @Override
    public void run(int runLength) {
        if(isActive) {
            if (this.length >= runLength) {
                System.out.println("Человек " + this.name + " пробежал забег длиной " + runLength);
            }
            else{
                System.out.println("Человек " + this.name + " не смог пробежать забед длиной " + runLength);
                isActive = false;
            }
        }
    }

    @Override
    public void jump(int obstacleLength) {
        if(isActive) {
            if (this.height >= obstacleLength)
                System.out.println("Человек " + this.name + " прыгнул через стену высотой " + obstacleLength);
            else{
                System.out.println("Человек " + this.name + " не смог перепрыгнуть стену высотой " + obstacleLength);
                isActive=false;
            }
        }
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public String toString() {
        return "Human {" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
