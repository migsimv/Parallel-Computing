public class Main {
    public static void main(String[] args) throws InterruptedException{
        Counter sc = new Counter();
        double[] numbers = new double[100];
        double ratio = 1.5;

        WriterThread wt = new WriterThread(sc, numbers, ratio);
        ReaderThread rt = new ReaderThread(sc, numbers);

        rt.reader_thread.start();
        wt.writer_thread.start();
        rt.reader_thread.join();
        wt.writer_thread.join();

        for(int i = 0; i < 100; i++){
                System.out.println("Writer list ["+ i +"] = " + wt.list[i] + ", reader list  ["+ i +"] = " + rt.list[i]);

        }

    }
}
