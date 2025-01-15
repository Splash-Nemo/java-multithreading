public class Incrementor extends Thread{
    private Counter counter;
    private int incvalue;

    public Incrementor(Counter counter, int incvalue){
        this.counter= counter;
        this.incvalue= incvalue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" increments value by "+incvalue);
        counter.incrementCount(incvalue);
    }
}
