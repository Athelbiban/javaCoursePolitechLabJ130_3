package producer_consumer;

class Store {

    private int product = 0;
    private final int CAPACITY = 30;

    public synchronized void getProduct(int amount) {

        System.out.println(Thread.currentThread().getName() + " прибыл на склад.");

        while (product < amount) {
            System.out.println("Недостаточно товара, " + Thread.currentThread().getName() + " ждет...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        product -= amount;
        System.out.println(
            Thread.currentThread().getName() + " купил " + amount + " товаров. Товара на складе: " + product
        );
        notifyAll();

        System.out.println(Thread.currentThread().getName() + " покинул склад.");
    }

    public synchronized void putProduct(int amount) {

        System.out.println(Thread.currentThread().getName() + " прибыл на склад.");

        while (product + amount > CAPACITY) {
            System.out.println("Склад переполнен, " + Thread.currentThread().getName() + " ждет...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        product += amount;
        System.out.println(
            Thread.currentThread().getName() + " добавил " + amount + " товаров. Товара на складе: " + product
        );
        notifyAll();

        System.out.println(Thread.currentThread().getName() + " покинул склад.");
    }
}
