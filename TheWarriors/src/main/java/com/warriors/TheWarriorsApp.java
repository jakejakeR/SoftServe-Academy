package com.warriors;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Warriors app!
 */
public class TheWarriorsApp {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");

        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerQueue.add(i);
        }

        System.out.println(integerQueue.isEmpty());

        while (!integerQueue.isEmpty()) {
            if (integerQueue.peek() % 2 == 0) {
                integerQueue.remove();
            }
            Integer polledInteger = integerQueue.poll();
            System.out.println(polledInteger);
        }
        System.out.println(integerQueue.isEmpty());
    }
}
