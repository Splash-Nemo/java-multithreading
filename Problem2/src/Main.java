import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> itemsList= new ArrayList<>();

        Thread producer= new Thread(new Producer(10, itemsList));
        Thread consumer= new Thread(new Consumer(itemsList));

        producer.start();
        consumer.start();
    }
}
