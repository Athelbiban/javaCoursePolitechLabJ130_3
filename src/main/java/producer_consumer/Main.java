package producer_consumer;

public class Main {
    public static void main(String[] args) {

        Storage storage = new Storage();
        Producer p = new Producer(storage);
        Consumer c = new Consumer(storage);

        p.thread.start();
        c.thread.start();
    }
}
