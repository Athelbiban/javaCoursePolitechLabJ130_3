package producer_consumer;

class Scratch extends Thread {

    Scratch(String name) {
        super(name);
    }

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


public class Program {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
//        Scratch scratch = new Scratch("ScratchTread");
//        scratch.start();
        for (int i = 0; i < 6; i++) {
            new Scratch("Scratch " + i).start();
        }
//        try {
//            scratch.join();
//        } catch (InterruptedException e) {
//            System.out.printf("%s has been interrupted", scratch.getName());
//        }
        System.out.println("Main thread finished...");
    }
}
