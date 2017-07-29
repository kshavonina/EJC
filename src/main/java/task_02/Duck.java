package task_02;

/**
 * The class Duck represents a duck
 * with its own fly behaviour.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class Duck {
    /** Represents a type of fly behaviour. */
    FlyBehavior flyBehavior;

    /**
     * Performs a flight in accordance with
     * the type of duck's fly behaviour.
     */
    public void performFly() {
        flyBehavior.fly();
    }
}
