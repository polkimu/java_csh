package ch13.supercar;

public class HybridCar extends SuperCar {
    HybridCar(int zero100){ super(zero100); }

    @Override
    void move() {
        super.move();
        System.out.println("기름과 전기를 사용한다");
    }
}
