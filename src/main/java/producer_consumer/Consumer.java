package producer_consumer;

public class Consumer implements Runnable {

    Storage storage;
    Thread thread;

    public Consumer(Storage storage) {
        this.storage = storage;
        thread = new Thread(this, "Потребитель");
    }

    @Override
    public void run() {

        int i = 1;

        while(i < 4) {
            storage.get(i++);
        }
    }
}
