package com.lesson1.homework;

public class Main {

    public static void main(String[] args) {
        Wall wall = new Wall();
        Wall wall1 = new Wall();
        Runner run1 = new Runner();
        Runner run2 =new Runner();
        Obstacle[] overcomes ={wall,run1,run2,wall1};
        Human human1 = new Human("Дима", 5, 500);
        Human human2 = new Human("Вася", 2, 700);
        Cat cat1 = new Cat("Барсик", 10, 150);
        Cat cat2 = new Cat("Мурзик",11,100);
        Participant [] arr = {human1,human2,cat1,cat2,new Robot()};
        for (Participant e:arr) {
            System.out.println(e);
        }
        System.out.println("\n");
        for (Obstacle stop: overcomes) {
            System.out.println(stop);
        }
        System.out.println("\n");
        for (Participant participant: arr) {
            System.out.println(participant);
            for (Obstacle e:overcomes) {
                e.getOver(participant);
                if(!participant.isActive()){
                    break;
                }
            }
            System.out.println("\n");
        }
    }
}
