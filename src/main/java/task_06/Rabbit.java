package task_06;

import java.io.IOException;

public class Rabbit {
    public volatile static boolean isEating = false;

    public static void main(String[] args) {
        new Rabbit.EatCarrot().start();
        new Rabbit.StopEating().start();
    }

    public static class EatCarrot extends Thread {
        @Override
        public void run() {
            isEating = true;
            System.err.println("Rabbit is eating.");
        }
    }

    public static class StopEating extends Thread {
        @Override
        public void run() {
            try {
                int k = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            isEating = false;
            System.err.println("Rabbit stopped eating.");
        }
    }
}
