import java.util.Objects;

public abstract class TransportVehicle {
    protected String brand;
    protected int maxSpeed;

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

    public abstract String getInfo();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TransportVehicle that = (TransportVehicle) obj;
        return brand.equals(that.brand) && maxSpeed == that.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, maxSpeed);
    }

    @Override
    public String toString() {
        return "TransportVehicle{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
