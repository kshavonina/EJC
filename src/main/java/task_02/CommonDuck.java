package task_02;

/**
 * The CommonDuck class represents a common duck.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class CommonDuck extends Duck {
    /**
     * Initializes a newly created object
     * with FlyWithWings fly behaviour.
     */
    public CommonDuck() {
        flyBehavior = new FlyWithWings();
    }
}
