
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 200, 4);
        car.showInfo();

        Train train = new Train("РЖД", 300, 10);
        train.showInfo();

        Express express = new Express("Сапсан", 350, 8, "Москва");
        express.showInfo();
    }
}