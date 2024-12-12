package vehicles;

public class Car extends Vehicle {
    private int numDoors;

    public Car(int numWheels, Fuel fuel, String model, String brand, String plate, int numDoors) {
        super(numWheels, fuel, model, brand, plate, "Car");
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return this.numDoors;
    }

    @Override
    public void move(int distance) {
        int vel = 40;
        int time = ((distance / (vel * 1000)) * 3600);
        System.out.println(String.format("Llegará a esa distancia en %d segundos.", time));
    }

    @Override
    public String toString() {
        return String.format("%s\n\tNúmero de puertas: %d", super.toString(), this.numDoors);
    }
}