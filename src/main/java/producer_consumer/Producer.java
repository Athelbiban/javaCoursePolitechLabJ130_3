package producer_consumer;

class Producer extends Thread {

    private Store store;
    private Thread thread;

    public Producer(Store store, String name) {

        this.store = store;
        thread = new Thread(this, name);
    }

    @Override
    public void run() {

        while (true) {
            int amount = (int) (Math.random() * 10) + 1;
            int time = (int) (Math.random() * 1000);

            store.putProduct(amount);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

}
