package producer_consumer;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(store, "Производитель_" + i);
            producer.getThread().start();
        }

        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(store, "Потребитель_" + i);
            consumer.getThread().start();
        }

    }
}