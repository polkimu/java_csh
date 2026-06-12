package ch13.supercar;

public class Driver {
    void drive(SuperCar car){
        car.move();

        if(car instanceof Chargeable){ // interface 사용
            ((Chargeable) car).charge();
        }
    }
}
