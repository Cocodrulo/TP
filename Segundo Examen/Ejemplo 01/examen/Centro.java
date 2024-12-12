package examen;

public class Centro {
    private int pequeñasDisp;
    private int grandesDisp;

    private int pequeñasTotal = 0;
    private int grandesTotal = 0;
    
    public Centro(int pequeñasDisp, int grandesDisp) {
        this.pequeñasDisp = pequeñasDisp;
        this.grandesDisp = grandesDisp;
    }

    public synchronized int reservar(int nEstudiantes) throws InterruptedException {
        if ((nEstudiantes < 2) || (nEstudiantes > Main.CAPACIDAD_GRANDE)) return 0;

        while ((grandesDisp < 1) && ((pequeñasDisp > 1 && nEstudiantes > Main.CAPACIDAD_SIMPLE) || (pequeñasDisp < 1)))  {
            wait();
        }

        if (nEstudiantes <=3 ) {
            pequeñasDisp--;
            pequeñasTotal++;
            return 1;
        }

        grandesDisp--;
        grandesTotal++;
        return 2;
    }

    public synchronized void liberar(int tipoSala) {
        if (tipoSala == 1) {
            pequeñasDisp++;
        } else {
            grandesDisp++;
        }
        notifyAll();
    }

    public int getPequeñasTotales() {
        return this.pequeñasTotal;
    }
    
    public int getGrandesTotales() {
        return this.grandesTotal;
    }

}