public class Counter {
    int counter = -1;

    public synchronized void await(int val) throws InterruptedException{
        while(val > counter){
            wait();
        }
    }
    public synchronized void advance(){
        counter++;
        notifyAll();
    }
    public int read(){
        return counter;
    }

}