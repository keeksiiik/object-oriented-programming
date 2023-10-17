public class TransportVehicle {
    private String brand;
    private int maxSpeed;

    public TransportVehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void showInfo() {
        System.out.println("Бренд: " + brand);
        System.out.println("Максимальная скорость: " + maxSpeed + " км/ч");
    }
}
