package task_02;

/**
 * The FlyWithWings class represents a type of fly behavior
 * when an object can fly using wings.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class FlyWithWings implements FlyBehavior {
    /** Speed of flight. */
    private int flyingSpeed;

    /**
     * Initializes a newly created object
     * and set flight speed.
     */
    public FlyWithWings() {
        this.setFlyingSpeed();
    }

    /**
     * Prints "I'm flying with my wings!" to the console.
     */
    @Override
    public void fly() {
        System.out.println("I'm flying with my wings!");
    }

    /**
     * Sets a random flight speed in the range of 20 to 110 km/s.
     */
    private void setFlyingSpeed() {
        int randSpeed = (int) Math.round(Math.random() * 90.0) + 10;

        if (randSpeed > 55) {
            randSpeed = randSpeed >> 1;
        } else {
            randSpeed = randSpeed << 1;
        }

        this.flyingSpeed = randSpeed;
    }

    /**
     * Returns flight speed.
     *
     * @return flight speed.
     */
    public int getFlyingSpeed() {
        return this.flyingSpeed;
    }
}
