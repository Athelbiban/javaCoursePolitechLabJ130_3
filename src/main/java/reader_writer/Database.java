package reader_writer;

class Database {

    private int readers = 0;
    private int writers = 0;

    public synchronized void startRead() throws InterruptedException {
        while (writers > 0) {
            System.out.println("Читатель ждет, пока писатель завершит работу");
            wait();
        }
        readers++;
        System.out.println("Читатель начал чтение. Читателей: " + readers);
    }

    public synchronized void endRead() {
        readers--;
        System.out.println("Читатель завершил чтение. Читателей: " + readers);
        notifyAll();
    }

    public synchronized void startWrite() throws InterruptedException {
        while (readers > 0 || writers > 0) {
            System.out.println("Писатель ждет, пока все читатели завершат");
            wait();
        }
        writers++;
        System.out.println("Писатель начал запись");
    }

    public synchronized void endWrite() {
        writers--;
        System.out.println("Писатель завершил запись");
        notifyAll();
    }

}
