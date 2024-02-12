package producer_consumer;

class Producer extends Thread {

    private Store store;
    private Thread thread;

    @Override
    public void run() {

        int n = 0;
        while (n++ < 4) {
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

    public Producer(Store store, String name) {

        this.store = store;
        thread = new Thread(this, name);
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
