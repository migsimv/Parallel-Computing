public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threads = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        int iterationCount = 10;
        int workload = cols / threads;

        GameOfLife gameOfLife = new GameOfLife(iterationCount, cols, cols);
        Barrier barrier = new Barrier(threads);
        gameOfLife.start();

        long startTime = System.currentTimeMillis();

        Worker[] workerThreads = new Worker[threads];

        for (int i = 0; i < threads; i++) {
            (workerThreads[i] =
                    new Worker(barrier, gameOfLife, workload * i, workload * (i+1) - 1)
            ).start();
        }
        for (int i = 0; i < threads; i++) {
                workerThreads[i].join();
        }

        long finishTime = System.currentTimeMillis();
        double time = (finishTime - startTime)/1000.;

        System.out.println(time);
    }
}