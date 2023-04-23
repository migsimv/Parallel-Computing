import java.math.BigDecimal;

class MyThread extends Thread {

    GeometricProgression prog;
    public static int n = 1000;
    public MyThread(GeometricProgression prog){
        this.prog = prog;
    }
    public void run(){

        System.out.println("Gija " + this + " paleista");
        for(int i = 0; i < n; i++){
//            synchronized(prog){
                prog.padidinti();
//            }
        }}
    public static void pradeti(){

        GeometricProgression prog = new GeometricProgression();
        prog.value = new BigDecimal("2.0");
        prog.ratio =  new BigDecimal("1.1");
        BigDecimal v = new BigDecimal("2.0");
        BigDecimal r = new BigDecimal("1.1");

        for (int i = 0; i < 2*n; i++) {
            v = v.multiply(r);
        }
        try{
            Thread t1 = new MyThread(prog);
            t1.start();

            Thread t2 = new MyThread(prog);
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Rezultatas n = " + prog.value + "\nturi buti " + v);

        }catch (InterruptedException exc){
            System.out.println("Ivyko klaida "+exc);
        }
    }
}

