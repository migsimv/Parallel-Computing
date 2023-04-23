public class WriterThread{
    Counter sc;
    double[] list;
    double ratio;
    public WriterThread(Counter sc, double[] list, double ratio){
        this.sc = sc;
        this.list = list;
        this.ratio = ratio;
    }

    Thread writer_thread = new Thread(new Runnable() {
        public void run(){
            int currentValue;
            for(int i = 0; i < 90; i++){
                currentValue = sc.read();
                sc.advance();

                if(i == 89){
                    list[currentValue + 1]= -1;
                }
                else {
                    list[currentValue + 1] = i * ratio;
                }
            }
        }
    });
}