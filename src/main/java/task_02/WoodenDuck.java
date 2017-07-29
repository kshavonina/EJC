package task_02;

/**
 * The WoodenDuck class represents a wooden duck.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class WoodenDuck extends Duck {
    /**
     * Initializes a newly created object
     * with FlyNoWay fly behaviour, since
     * wooden duck can not fly.
     */
    public WoodenDuck() {
        this.flyBehavior = new FlyNoWay();
    }
}
