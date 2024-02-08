
class Worker extends Thread {
    private final int firstRow;
    private final int lastRow;
    private final Barrier barrier;
    private final GameOfLife gameOfLife;

    public Worker(Barrier barrier, GameOfLife gameOfLife, int firstRow, int lastRow) {
        this.barrier = barrier;
        this.gameOfLife = gameOfLife;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
    }

    public void run() {
        try {
            for (int i = 1; i <= gameOfLife.iterationCount; i++){
                System.out.println(i);
                gameOfLife.updateNeighbourCount(firstRow, lastRow);
                barrier.waitBarrier();
                gameOfLife.swap(firstRow, lastRow);
                barrier.waitBarrier();

            }

        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
