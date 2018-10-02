package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by imladyartist on 9/21/18.
 */
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List list) {
        this.horses = list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    Map<String, Double> points = new HashMap<>();


    static Hippodrome game;

    void run() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            move();
            print();
            for (Horse h : horses) {
                if(points.containsKey(h.getName()))
                    points.put(h.getName(), points.get(h.getName()) + h.getDistance());
                else
                    points.put(h.getName(), h.getDistance());
            }
            Thread.sleep(200);
        }
    }

    void move() {


        for (Horse h:horses) {
            h.move();
        }

    }

    void print() {

        for (Horse h: horses) {
            h.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public Horse getWinner() {

        Double max = 0.0;
        Horse winner = null;

        for (Horse h:horses) {

            Double d = h.getDistance();


            if (winner == null || d.compareTo(max) > 0) {
                winner = h;
            }

        }


        return winner;
    }

    public void printWinner() {

        System.out.println("Winner is " + getWinner().getName() + "!");
    }



    public static void main(String[] args) {


        List<Horse> tempHorses = new ArrayList<>();
        tempHorses.add(new Horse("Flash", 3, 0));
        tempHorses.add(new Horse("Rapida", 3, 0));
        tempHorses.add(new Horse("Arrow", 3, 0));

        game = new Hippodrome(tempHorses);
        try {
            game.run();
            game.printWinner();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
