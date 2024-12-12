package cloud;

public class Client extends Thread {
    
    private final String id;
    private final Resources res;
    private final int rep;
    private final ComputingService service;
    
    public Client(String id, ComputingService service, Resources res, int rep) {
        this.id = id;
        this.res = res;
        this.rep = rep;
        this.service = service;

        setName(this.id);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < this.rep; i++) {
                if (this.service.request(res)) {
                    Simulador.log(this.id + ": Recursos reservados ", res);
                } else {
                    Simulador.log(this.id + ": Recursos fuera de rango ", res);
                }

                sleep(res.getCpu());

                this.service.release(res);
                Simulador.log(this.id + ": Recursos liberados ", res);

                sleep(50);
            }
        } catch (InterruptedException e) {}
    }
}