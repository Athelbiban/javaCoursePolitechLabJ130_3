package producer_consumer;

public class Producer implements Runnable {

    Storage storage;
    Thread thread;

    public Producer(Storage storage) {
        this.storage = storage;
        this.thread = new Thread(this, "Производитель");
    }

    @Override
    public void run() {

        int i = 1;

        while(i < 4) {
            storage.put(i++);
        }
    }
}
