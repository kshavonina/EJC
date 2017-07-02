package task02;

public class FlyNoWay implements FlyBehavior {
    private final static int flyingSpeed = 0;

    @Override
    public void fly() {
        System.out.println("I cry, I can not fly...");
    }

    public int getFlyingSpeed() {
        return flyingSpeed;
    }
}
