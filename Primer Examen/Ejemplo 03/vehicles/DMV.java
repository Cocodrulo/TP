package vehicles;

import java.util.*;

public class DMV {
    private List<Vehicle> vehicleList;

    public DMV() {
        this.vehicleList = new ArrayList<>();
    }

    public DMV(Vehicle[] vehicleArray) {
        this.vehicleList = new ArrayList<>();

        for (Vehicle vehicle: vehicleArray) {
            this.vehicleList.add(vehicle);
        }
    }

    public boolean add(Vehicle vehicle) {
        if (vehicle == null || vehicle.getModel().equals("")) return false;

        for (Vehicle veh: this.vehicleList) {
            if (veh.equals(vehicle)) return false;
        }

        this.vehicleList.add(vehicle);
        return true;
    }

    public boolean remove(String plate) {
        for (Vehicle vehicle: this.vehicleList) {
            if (vehicle.getPlate().equals(plate)) {
                this.vehicleList.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public int size() {
        System.out.println("meow");
        return this.vehicleList.size();
    }

    public Collection<Vehicle> getVehicleByPlate(String plate) {
        List<Vehicle> vehicleByPlate = new ArrayList<>();

        for (Vehicle vehicle: this.vehicleList) {
            if (vehicle.getPlate().contains(plate)) {
                vehicleByPlate.add(vehicle);
            }
        }

        Collections.sort(vehicleByPlate);

        return vehicleByPlate;
    }

    @Override
    public String toString() {
        if (this.vehicleList.isEmpty()) return "No hay vehículos en la base de datos";
        Collection<Vehicle> sortedList = this.getVehicleByPlate("");

        int listLength = sortedList.size();
        String result = String.format("Hay %d vehículos en la base de datos:\n", listLength);

        for (Vehicle vehicle: sortedList) {
            result += vehicle.toString() + "\n";
        }
        return result;
    }
}