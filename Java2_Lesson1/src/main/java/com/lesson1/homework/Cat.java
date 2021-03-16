package com.lesson1.homework;

public class Cat implements Participant{
    String name;
    int height;
    int length;
    boolean isActive;

    public Cat(String name, int height, int length) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.isActive=true;
    }

    @Override
    public void run(int runLength) {
        if (isActive) {
            if (this.length >= runLength) {
                System.out.println("Кот " + this.name + " побежал забег длиной " + runLength);
            } else {
                System.out.println("Кот " + this.name + " не смог пробежать забег длиной " + runLength);
                isActive = false;
            }
        }
    }

    @Override
    public void jump(int obstacleLength) {
        if(isActive) {
            if (this.height >= obstacleLength)
                System.out.println("Кот " +this.name+ " прыгнул через стену высотой "+ obstacleLength);
            else{
                System.out.println("Кот " + this.name + " не смог перепрыгнуть стену высотой " + obstacleLength);
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
        return "Cat {" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
