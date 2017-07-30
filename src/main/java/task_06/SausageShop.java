package task_06;

/**
 * Multithreading. Example of using "synchronized" key word.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class SausageShop {
    private static int moneyForSausage = 1250;

    public static void main(String[] args) {
        goToShop(8);
    }

    /**
     * Go to shop to buy a certain amount of sausage.
     *
     * @param amount is an amount of sausage to buy.
     */
    private static void goToShop(int amount) {
        for (int i = 0; i < amount; i++) {
            //new Thread(() -> buySausage()).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buySausage();
                }
            }).start();
        }
    }

    /**
     * A synchronized method can be executed only by one thread at the same time.
     * If it is not synchronized we try to buy sausage when we don't have enough money,
     * but we don't know about it.
     */
    private synchronized static void buySausage() {
        int sausagePrice = 250;

        if (moneyForSausage >= sausagePrice) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            moneyForSausage -= sausagePrice;

            System.err.println("We bought one sausage and so we have money: " + moneyForSausage);
        } else {
            System.err.println("We have no enough money to buy one more sausage.");
        }
    }
}
