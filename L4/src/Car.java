public class Car extends TransportVehicle {
    private int numberOfDoors;

    public Car(String brand, int maxSpeed, int numberOfDoors) {
        super(brand, maxSpeed);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Количество дверей: " + numberOfDoors);
    }

    @Override
    public String getInfo() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }

    // Дополнительный метод только для класса Car
    public void drive() {
        System.out.println("Машина едет");
    }
}
