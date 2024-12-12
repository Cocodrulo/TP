package cloud;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * Contiene el método "main" y funciones de utilidades.
 * La función "createResources()" se puede usar para instanciar objetos de tipo
 * "Resources" con valores aleatorios.
 * 
 */
public class Simulador {

    private static final long TINI = System.currentTimeMillis();

    private static final int N_CLIENTS = 10;
    private static final int N_ITERATIONS = 2;

    private static final long MAX_CPU = 6000;
    private static final int MAX_MEM = 100;

    public static void main(String[] args) {

        // Crear instancia de Servicio de Computación
        ComputingService service = new ComputingService(MAX_CPU, MAX_MEM);

        // Crear 10 clientes
        Client[] clients = new Client[N_CLIENTS];

        // Iniciar la ejecución de los 10 clientes
        for (int i = 0; i < N_CLIENTS; i++) {
            Resources resources = createResources();
            clients[i] = new Client("Client-" + (i + 1), service, resources, N_ITERATIONS);
        }

        // Iniciar thread de tipo daemon
        for (Thread client : clients) {
            client.start();
        }

        // Esperar a la finalización de los 10 clientes
        for (Thread client : clients) {
            try {
                client.join();
            } catch (InterruptedException ignored) {}
        }

        // Mostrar la cantidad total de CPU y memoria consumida
        log("Recursos totales ", new Resources(service.getTotalCpu(), service.getTotalMem()));
    }

    /**
     * Crea un objeto de tipo Resources con valores aleatorios.
     */
    static Resources createResources() {
        final long MAX_CPU_SECS_PER_TASK = 3;
        final int MAX_MEM_PER_TASK = 30;

        long cpuTime = ThreadLocalRandom.current().nextLong(MAX_CPU_SECS_PER_TASK) + 1;
        int memory = ThreadLocalRandom.current().nextInt(MAX_MEM_PER_TASK) + 1;

        return new Resources(cpuTime * 1000, memory);
    }

    /**
     * Imprime un cadena con la forma "CPU total: [valor] , Mem total: [valor]"
     */
    public static void log(String cadena, Resources res) {
        long cur = System.currentTimeMillis();
        String message = String.format("%s (CPU: %d, Mem: %d)", cadena, res.getCpu(), res.getMem());
        String t = String.format("%.6f \033[1;33m%s\033[m\n", (cur - TINI) / 1000.0, message);
        synchronized (System.out) {
            System.out.print(t);
        }
    }
}