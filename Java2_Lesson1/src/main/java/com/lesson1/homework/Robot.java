package com.lesson1.homework;

public class Robot implements Participant{
private String name;
public Robot(){
    this.name="Федор";
}
    @Override
    public void run(int runLength) {
        System.out.println("Я механический робот "+this.name+", могу бежать сколько угодно, даже "+runLength);
    }

    @Override
    public void jump(int obstacleLength) {
        System.out.println("Я механический робот "+this.name+", могу преодолеть любую стену, даже стену высотой "+obstacleLength);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public String toString() {
        return "Robot {" +
                "name='" + name + '\'' +
                '}';
    }
}
