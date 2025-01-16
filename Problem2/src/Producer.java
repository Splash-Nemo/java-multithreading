import java.util.ArrayList;
public class Producer implements Runnable{

    private int size;
    private ArrayList<String> itemsList= new ArrayList<>();

    public Producer(int size, ArrayList<String> itemsList){
        this.size= size;
        this.itemsList= itemsList;
    }

    public Producer(){}

    @Override
    public void run() {
        while(true){
            synchronized (itemsList){
                while(itemsList.size()==size){
                    try {
                        itemsList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                itemsList.add("Item-"+Integer.toString(itemsList.size()+1));
                System.out.println("Producer Added: "+itemsList.get(itemsList.size()-1));

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
