package producer_consumer;

public class Storage {

    private volatile int amount = 0;
    boolean valueSet = false;

    public synchronized void put(int count) {

        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        amount += count;
        valueSet = true;
        System.out.println("Отправлено на склад: " + count + " Остаток на складе: " + amount);
        notify();
    }

    public synchronized void get(int count) {

        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        amount -= count;
        valueSet = false;
        System.out.println("Получено со склада: " + count + " Остаток на складе: " + amount);
        notify();
    }

    private synchronized int getAmount() {
        return amount;
    }
}
