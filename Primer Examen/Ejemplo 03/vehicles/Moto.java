package vehicles;

public class Moto extends Vehicle { 
    private int displacement;

    public Moto(int numWheels, Fuel fuel, String model, String brand, String plate, int displacement) {
        super(numWheels, fuel, model, brand, plate, "Moto");
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    @Override
    public void move(int distance) {
        int vel = 60;
        int time = ((distance / (vel * 1000)) * 3600);
        System.out.println(String.format("Llegará a esa distancia en %d segundos.", time));
    }

    @Override
    public String toString() {
        return String.format("%s\n\tCilindrada: %d", super.toString(), this.displacement);
    }
}
