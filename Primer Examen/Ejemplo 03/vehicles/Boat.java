package vehicles;

public class Boat extends Vehicle implements Communicable, Navegable {
    private int capacity;

    public Boat(int numWheels, Fuel fuel, String model, String brand, String plate, int capacity) {
        super(numWheels, fuel, model, brand, plate, "Boat");
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void move(int distance) {
        int vel = 90;
        int time = ((distance / (vel * 1000)) * 3600);
        System.out.println(String.format("Llegará a esa distancia en %d segundos.", time));
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(String.format("El avión con matrícula %s ha dicho %s", this.getPlate(), message));
    }

    @Override
    public void setSail() {
        System.out.println("El barco ha zarpado");
    }

    @Override
    public void dock() {
        System.out.println("El barco ha atracado");
    }

    @Override
    public String toString() {
        return String.format("%s\n\tCapacidad: %d", super.toString(), this.capacity);
    }
}
