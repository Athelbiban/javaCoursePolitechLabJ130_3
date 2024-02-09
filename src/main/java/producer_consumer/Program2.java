package producer_consumer;

class Scratch2 implements Runnable {

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class Program2 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread started...");
        Runnable r = () -> {
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        };
        Thread myScratch = new Thread(r, "Scratch2");
        myScratch.start();
        myScratch.join();
        System.out.println("Main thread finished...");

    }
}