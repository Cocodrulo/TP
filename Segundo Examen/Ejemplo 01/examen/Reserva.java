package examen;

public class Reserva extends Thread {
    private final Centro centro;
    private int estudiantes;

    public Reserva(String id, Centro centro, int estudiantes) {
        this.centro = centro;
        this.estudiantes = estudiantes;

        setName(id);
    }

    @Override
    public void run() {
        for (int n = 0; n < Main.N_VECES; n++) {
            Main.log("Solicitando sala para " + estudiantes + " estudiantes.");

            try {
                int sala = centro.reservar(estudiantes);
                if (sala == 0) {
                    Main.log("Solicitud rechazada para " + estudiantes + " estudiantes");
                    return;
                } else if (sala == 1) {
                    Main.log("Asignada sala tipo simple");
                } else {
                    Main.log("Asignada sala tipo grande");
                }
                Main.log("Usando sala");

                Thread.sleep(Main.getTimeUse());
                centro.liberar(sala);
                Main.log("Sala liberada");
                sleep(50);
            } catch (InterruptedException e) {}
        }
    }
}