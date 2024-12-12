package examen;

public class Main {
    private static final long TINI = System.currentTimeMillis();
    private static java.util.Random rand = new java.util.Random();

    public static final int N_VECES = 2;

    public static final int SALAS_SIMPLES = 3;
    public static final int SALAS_GRANDES = 4;

    public static final int CAPACIDAD_SIMPLE = 3;
    public static final int CAPACIDAD_GRANDE = 5;

    public static final int NUM_RESERVAS = 15;

    public static void main(String[] args) throws InterruptedException {
        Centro centro = new Centro(SALAS_SIMPLES, SALAS_GRANDES);
        
        Reserva[] reservas = new Reserva[NUM_RESERVAS];
        
        for (int n = 0; n < NUM_RESERVAS ; n++) {
            reservas[n] = new Reserva("R" + (n + 1), centro, getRandomStudents());
        }

        for (Reserva reserva : reservas) {
            reserva.start();
        }

        for (Reserva reserva : reservas) {
            reserva.join();
        }
    
        log("Termina");
        log("Total de salas pequeñas " + centro.getPequeñasTotales());
        log("Total de salas grandes " + centro.getGrandesTotales());
    }

    public static void log(String msg) { 
        long curr = System.currentTimeMillis();
        String t = String.format("%6.1fs \033[1;33m%s: %s\033[0m\n", (curr - TINI) / 1000.0, Thread.currentThread().getName(), msg);

        synchronized (System.out) {
            System.out.print(t);
        }
    }

    public static long getTimeUse() {
        return 150 + rand.nextLong(550);
    }

    public static int getRandomStudents() {
        return 1 + rand.nextInt(7);
    }
}