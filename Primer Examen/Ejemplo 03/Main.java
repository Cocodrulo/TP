import vehicles.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(4, Fuel.Diesel, "Corolla", "Toyota", "1234GHK", 4);
        Car car2 = new Car(4, Fuel.Gasoline, "Corolla", "Toyota", "1010JRK", 4);
        Car car3 = new Car(4, Fuel.Diesel, "Berlingo", "Citroen", "1234HEH", 4);
        Moto moto1 = new Moto(4, Fuel.Gasoline, "Motorola", "Yamaha", "0000OOO", 250);
        Car car4 = new Car(13, Fuel.Electric, "Global", "Guagua", "1010JRK", 1836930);

        Plane plane1 = new Plane(3, Fuel.Kerosene, "4785", "Boeing", "1017JRK", 1);
        Plane plane2 = new Plane(7, Fuel.Kerosene, "7777", "Boeing", "7777777", 7777777);

        Boat boat1 = new Boat(0, Fuel.Diesel, "Modelo de barco", "Fregolsen", "ABABABA", 629485);

        Vehicle[] cars = new Vehicle[] {car1, car2, car3, plane1};
        DMV database = new DMV(cars);

        System.out.println(database.toString());

        database.add(boat1);
        database.add(plane2);
        database.add(car4);
        database.add(moto1);

        System.out.println(database.toString());


        database.remove("1010JRK");

        System.out.println(database.toString());

        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
        System.out.println(database.size());
    }
}
