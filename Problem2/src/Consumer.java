import java.util.ArrayList;

public class Consumer implements Runnable {
    Producer obj= new Producer();
    ArrayList<String> itemsList;

    Consumer(ArrayList<String> itemsList){
        this.itemsList= itemsList;
    }
    @Override
    public void run() {
        while (true){
            synchronized (itemsList){
                while(itemsList.isEmpty()){
                    try {
                        itemsList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Consumer Consumed: "+itemsList.getLast());

                itemsList.removeLast();
                itemsList.notify();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
