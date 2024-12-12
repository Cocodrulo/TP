package vehicles;

public class Plane extends Vehicle implements Communicable, Flyable {
    private int capacity;

    public Plane(int numWheels, Fuel fuel, String model, String brand, String plate, int capacity) {
        super(numWheels, fuel, model, brand, plate, "Plane");
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void move(int distance) {
        int vel = 200;
        int time = ((distance / (vel * 1000)) * 3600);
        System.out.println(String.format("Llegará a esa distancia en %d segundos.", time));
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(String.format("El avión con matrícula %s ha dicho %s", this.getPlate(), message));
    }

    @Override
    public void takeOff() {
        System.out.println("El avión ha despegado");
    }
    
    @Override
    public void land() {
        System.out.println("El avión ha aterrizado");
    }

    @Override
    public String toString() {
        return String.format("%s\n\tCapacidad: %d", super.toString(), this.capacity);
    }
}
