public class Main {
    public static void main(String[] args) {
        TransportVehicle car = new Car("Toyota", 200, 4);
        TransportVehicle train = new Train("RZD", 300, 10);
        TransportVehicle express = new Express("Sapsan", 350, 8, "Moscow");

        car.showInfo();
        System.out.println(car.getInfo());
        ((Car) car).drive(); // Пример полиморфизма метода

        train.showInfo();
        System.out.println(train.getInfo());
        ((Train) train).stop(); // Пример полиморфизма метода

        express.showInfo();
        System.out.println(express.getInfo());
    }
}