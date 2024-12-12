package vehicles;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {
    private int numWheels;
    private Fuel fuel;
    private String model;
    private String brand;
    private String plate;
    private String type;

    public Vehicle(int numWheels, Fuel fuel, String model, String brand, String plate, String type) {
        this.numWheels = numWheels;
        this.fuel = fuel;
        this.model = model;
        this.brand = brand;
        this.setPlate(plate);
        this.type = type;
    }

    public int getNumWheels() {
        return this.numWheels;
    }

    public Fuel getFuel() {
        return this.fuel;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getType() {
        return this.type;
    }

    public void setPlate(String plate) {
        if (plate.length() != 7) throw new Error("La matrícula debe tener 7 caracteres");
        this.plate = plate;
    }

    public abstract void move(int distance);

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) object;
        return this.plate.equals(other.getPlate()) && this.type.equals(other.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.plate);
    }

    @Override
    public int compareTo(Vehicle other) {
        if (!(this.brand.equals(other.getBrand()))) return this.brand.compareTo(other.getBrand());

        if (!(this.model.equals(other.getModel()))) return this.model.compareTo(other.getModel());

        return this.plate.compareTo(other.getPlate());
    }

    @Override
    public String toString() {
        return String.format("%s:\n\tNúmero de ruedas: %d\n\tTipo de combustible: %s\n\tModelo: %s\n\tMarca: %s\n\tTipo de vehículo: %s", this.plate, this.numWheels, this.fuel, this.model, this.brand, this.type);
    }
}