public class ReaderThread {
    Counter sc;
    double[] given_list;
    double[] list = new double[100];

    public ReaderThread(Counter sc, double[] given_list){
        this.sc = sc;
        this.given_list = given_list;
    }

    Thread reader_thread = new Thread(new Runnable() {
        public void run(){
            int i = 0;
            do{
                System.out.println(i);
                try{
                    sc.await(i);
                    list[i] = given_list[i];
                    i++;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            } while(list[i-1] != -1);
        }
    });
}
