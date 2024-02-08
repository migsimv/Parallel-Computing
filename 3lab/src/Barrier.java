
class Barrier {
    private int threads = 0;
    private final int providedThreads;

    public Barrier(int providedThreads) {
        this.providedThreads = providedThreads;
    }

    public synchronized void waitBarrier() throws InterruptedException {
        threads++;
        if (threads == providedThreads) {
            notifyAll();
            threads = 0;
        } else {
            wait();
        }
    }
}