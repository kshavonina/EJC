package task_02;

/**
 * The DuckCasino class represents a game of duck casino.
 *
 * @author Kseniya Shavonina
 * @version 2.0
 */
public class DuckCasino {
    /** Player's bank. */
    private int bank = 500;

    public static void main(String[] args) {
        DuckCasino newGame = new DuckCasino();

        for (int i = 0; i < 5; i++) {
            newGame.playCasino();

            if (newGame.bank < 100) {
                System.out.println("Sorry, game over.");
                break;
            }
        }

        System.out.println();
        System.out.println("Your bank: " + newGame.bank);
    }

    /**
     * The process of the game.
     */
    private void playCasino() {
        this.bank -= 100;
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
                this.bank += 200;
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
     * The duck must fly 650 km in 10 seconds to win the bet.
     *
     * @param speed is duck's speed of flying.
     * @return true if bet won, false if not.
     */
    private static boolean isBetWins(int speed) {
        return speed * 10 > 650;
    }
}
