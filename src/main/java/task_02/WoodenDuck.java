package task_02;

public class WoodenDuck extends Duck {
    public WoodenDuck() {
        flyBehavior = new FlyNoWay();
    }
}
