public class Train extends TransportVehicle {
    private int numberOfCars;

    public Train(String brand, int maxSpeed, int numberOfCars) {
        super(brand, maxSpeed);
        this.numberOfCars = numberOfCars;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Количество вагонов: " + numberOfCars);
    }
}
