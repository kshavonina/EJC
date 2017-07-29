package task_02;

/**
 * This class represents a game of duck casino.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class Main {
    /** Player's bank. */
    private static int bank = 500;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            playCasino();
            if (bank < 100) {
                System.out.println("Sorry, game over.");
                break;
            }
        }

        System.out.println();
        System.out.println("Your bank: " + bank);
    }

    /**
     * The process of the game.
     */
    private static void playCasino() {
        bank -= 100;
        double randValue = Math.random();
        Duck duck;
        if (randValue > 0.5) {
            duck = new CommonDuck();
            System.out.println("You're lucky! Your duck can fly!");
        } else {
            duck = new WoodenDuck();
            System.out.println("Ha-ha! You've got a wooden duck!");
        }

        if (duck.flyBehavior instanceof FlyWithWings) {
            FlyWithWings flyBehavior = (FlyWithWings) duck.flyBehavior;
            if (isBetWins(flyBehavior.getFlyingSpeed())) {
                bank += 200;
                System.out.println("Speed of your duck: " + flyBehavior.getFlyingSpeed());
                System.out.println("Distance: " + 10 * flyBehavior.getFlyingSpeed());
                System.out.println("Congratulations! Your bet wins!");
                System.out.println();
            } else {
                System.out.println("Speed of your duck: " + flyBehavior.getFlyingSpeed());
                System.out.println("Distance: " + 10 * flyBehavior.getFlyingSpeed());
                System.out.println("Sorry, you lose.");
                System.out.println();
            }
        } else if (duck.flyBehavior instanceof FlyNoWay) {
            System.out.println("Speed of your duck: " + 0);
            System.out.println("Distance: " + 0);
            System.out.println("Sorry, you lose.");
            System.out.println();
        }
    }

    /**
     * This method checks whether the bet won or not.
     * The duck must fly 650 km in 10 seconds to win.
     *
     * @param speed is duck's speed of flying.
     * @return true if bet won, false if not.
     */
    private static boolean isBetWins(int speed) {
        return speed * 10 > 650;
    }
}
