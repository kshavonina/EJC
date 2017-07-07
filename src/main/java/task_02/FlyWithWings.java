package task_02;

public class FlyWithWings implements FlyBehavior {
    private int flyingSpeed;

    public FlyWithWings() {
        this.setFlyingSpeed();
    }

    @Override
    public void fly() {
        System.out.println("I'm flying with my wings!");
    }

    public void setFlyingSpeed() { // 20-110 km per sec
        int randSpeed = (int) Math.round(Math.random() * 90.0) + 10;
        //System.out.println(randSpeed);

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