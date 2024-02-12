package producer_consumer;

class Store {

    private int product = 0;
    private final int CAPACITY = 30;

    public synchronized void getProduct(int amount) {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " прибыл на склад.");

        while (product < amount) {
            System.out.println("Недостаточно товара, " + threadName + " ждет...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        product -= amount;
        System.out.println(threadName + " купил " + amount + " товаров. Товара на складе: " + product);
        notifyAll();
        System.out.println(threadName + " покинул склад.");
    }

    public synchronized void putProduct(int amount) {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " прибыл на склад.");

        while (product + amount > CAPACITY) {
            System.out.println("Склад переполнен, " + threadName + " ждет...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        product += amount;
        System.out.println(threadName + " добавил " + amount + " товаров. Товара на складе: " + product);
        notifyAll();
        System.out.println(threadName + " покинул склад.");
    }
}
