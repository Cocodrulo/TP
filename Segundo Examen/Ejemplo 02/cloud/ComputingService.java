package cloud;

public class ComputingService {

    private final long maxCpu;
    private final int maxMem;

    private long availableCpu;
    private int availableMem;

    private long totalCpu = 0;
    private int totalMem = 0;

    public ComputingService(long maxCpu, int maxMem) {
        this.maxCpu = maxCpu;
        this.maxMem = maxMem;

        this.availableCpu = maxCpu;
        this.availableMem = maxMem;
    }

    public long getTotalCpu() {
        return this.totalCpu;
    } 

    public int getTotalMem() {
        return this.totalMem;
    }

    public synchronized boolean request(Resources res) throws InterruptedException {
        if (res.getCpu() > this.maxCpu || res.getMem() > this.maxMem) {
            return false;
        }

        while (res.getCpu() > this.availableCpu || res.getMem() > this.availableMem) {
            wait();
        }

        this.availableCpu -= res.getCpu();
        this.totalCpu += res.getCpu();
        this.availableMem -= res.getMem();
        this.totalMem += res.getMem();

        return true;
    }

    public synchronized void release(Resources res) {
        this.availableCpu += res.getCpu();
        this.availableMem += res.getMem();

        notifyAll();
    }

    public synchronized Resources getServedResources() {
        Resources res = new Resources(this.totalCpu, this.totalMem);
        return res;
    }
}
