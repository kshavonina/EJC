package task_02;

/**
 * The FlyNoWay class represents a type of fly behavior
 * when an object can not fly.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class FlyNoWay implements FlyBehavior {
    /** Speed of flight */
    private final static int flyingSpeed = 0;

    /**
     * Prints "I cry, I can not fly..." to the console.
     */
    @Override
    public void fly() {
        System.out.println("I cry, I can not fly...");
    }

    /**
     * Returns flight speed.
     *
     * @return flight speed.
     */
    public int getFlyingSpeed() {
        return flyingSpeed;
    }
}
