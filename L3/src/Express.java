public class Express extends Train {
    private String destination;

    public Express(String brand, int maxSpeed, int numberOfCars, String destination) {
        super(brand, maxSpeed, numberOfCars);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Место назначения: " + destination);
    }
}
