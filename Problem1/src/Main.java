public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter= new Counter();
        System.out.println("Initial Value: "+counter.getCount());

        int num= 6, value= 1;
        Incrementor[] incrementors= new Incrementor[num];

        for(int i=0; i<incrementors.length; i++){
            incrementors[i]= new Incrementor(counter, value);
            incrementors[i].start();
        }

        for(Incrementor i: incrementors){
            i.join();
        }

        System.out.println("Final Value: "+counter.getCount());
    }
}