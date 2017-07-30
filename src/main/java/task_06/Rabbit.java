package task_06;

import java.io.IOException;

/**
 * Multithreading. Example of using key word "volatile".
 * Rabbit eats carrot until we press "Enter".
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class Rabbit {
    /**
     * The flag indicates whether the rabbit is eating
     * carrot or not. If it doesn't have "volatile" modifier,
     * threads will not have the last value of it.
     */
    public volatile static boolean isEating = false;

    public static void main(String[] args) {
        new Rabbit.EatCarrot().start();
        new Rabbit.StopEating().start();
    }

    /**
     * The EatCarrot class represents rabbit eating carrot.
     */
    public static class EatCarrot extends Thread {
        @Override
        public void run() {
            isEating = true;
            System.err.println("Rabbit is eating.");

            while (isEating) {

            }

            System.err.println("Rabbit stopped eating.");
        }
    }

    /**
     * The StopEating class represents stop for eating carrot.
     */
    public static class StopEating extends Thread {
        @Override
        public void run() {
            try {
                int k = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            isEating = false;
            System.err.println("And we finally say: rabbit, enough to eat!");
        }
    }
}
