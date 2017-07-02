package task02;

public class FlyWithWings implements FlyBehavior {
    private int flyingSpeed;

    @Override
    public void fly() {
        System.out.println("I'm flying with my wings!");
    }

    public void setFlyingSpeed() { // 20-50 km per sec
        int randSpeed = (int) Math.round(Math.random() + 90.0) + 10;

        if (randSpeed > 55) {
            randSpeed = randSpeed >> 1;
        } else {
            randSpeed = randSpeed << 1;
        }

        this.flyingSpeed = randSpeed;
    }

    public int getFlyingSpeed() {
        return this.flyingSpeed;
    }
}
