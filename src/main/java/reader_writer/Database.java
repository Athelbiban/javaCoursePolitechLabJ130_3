package reader_writer;

class Database {

    private int readers = 0;
    private int writers = 0;

    public synchronized void startRead() throws InterruptedException {

        while (writers > 0) {
            System.out.println(Thread.currentThread().getName() + " ждет, пока завершит работу писатель");
            wait();
        }
        readers++;
        System.out.println(Thread.currentThread().getName() + " начал чтение. Читателей: " + readers);
    }

    public synchronized void endRead() {
        readers--;
        System.out.println(Thread.currentThread().getName() + " завершил чтение. Читателей: " + readers);
        notifyAll();
    }

    public synchronized void startWrite() throws InterruptedException {
        while (readers > 0 || writers > 0) {
            System.out.println(Thread.currentThread().getName() + " ждет, пока завершат работу все");
            wait();
        }
        writers++;
        System.out.println(Thread.currentThread().getName() + " начал запись");
    }

    public synchronized void endWrite() {
        writers--;
        System.out.println(Thread.currentThread().getName() + " завершил запись");
        notifyAll();
    }

}
